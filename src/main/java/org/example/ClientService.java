package org.example;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;




    public class ClientService {
        private Connection connection;

        public ClientService(Connection connection) {
            this.connection = connection;
        }

        public long create(String name) throws SQLException {
            validateName(name);

            String query = "INSERT INTO clients (name) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, name);
                statement.executeUpdate();
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating client failed, no ID obtained.");
                }
            }
        }

        public String getById(long id) throws SQLException {
            String query = "SELECT name FROM clients WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setLong(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("name");
                    } else {
                        throw new IllegalArgumentException("Client with ID " + id + " does not exist.");
                    }
                }
            }
        }

        public void setName(long id, String name) throws SQLException {
            validateName(name);

            String query = "UPDATE clients SET name = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, name);
                statement.setLong(2, id);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated == 0) {
                    throw new IllegalArgumentException("Client with ID " + id + " does not exist.");
                }
            }
        }

        public void deleteById(long id) throws SQLException {
            String query = "DELETE FROM clients WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setLong(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted == 0) {
                    throw new IllegalArgumentException("Client with ID " + id + " does not exist.");
                }
            }
        }

        public List<Client> listAll() throws SQLException {
            List<Client> clients = new ArrayList<>();
            String query = "SELECT id, name FROM clients";
            try (Statement statement =  connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    clients.add(new Client(id, name));
                }
            }
            return clients;
        }

        private void validateName(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty.");
            }
            // Add more validation rules if needed
        }
    }


