package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private   Database database=new Database("jdbc:postgresql://localhost:32768/modul1","postgres","1111");
    private     Connection conn= database.getINSTANCE().getConnection();
public List<MaxProjectCountClient>  finMaxprojectsClient(){
    List<MaxProjectCountClient> result=new ArrayList<>();
    String sqlFile ="./src/main/java/sql/find_max_projects_client.sql";
    String sqlQuery= readSqlFile(sqlFile);

    try {
        PreparedStatement statement= conn.prepareStatement(sqlQuery);

        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
            String name =resultSet.getString("name");
            int projectCount =resultSet.getInt("project_count");
            MaxProjectCountClient client =new  MaxProjectCountClient(name,projectCount);
result.add(client);
        }


    }catch (SQLException e){
        e.printStackTrace();
    }

    return result;
}
    public List<MaxSalaryWorker>  finMaxSalaryworkers(){
        List<MaxSalaryWorker> result=new ArrayList<>();
        String sqlFile ="./src/main/java/sql/find_max_salary_worker.sql";
        String sqlQuery= readSqlFile(sqlFile);

        try {
            PreparedStatement statement= conn.prepareStatement(sqlQuery);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                String name =resultSet.getString("name");
                int salary =resultSet.getInt("salary");
                MaxSalaryWorker client =new  MaxSalaryWorker(name,salary);
                result.add(client);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }    public List<LongestProject>  findLongestProject(){
        List<LongestProject> result=new ArrayList<>();
        String sqlFile ="./src/main/java/sql/find_longest_project.sql";
        String sqlQuery= readSqlFile(sqlFile);

        try {
            PreparedStatement statement= conn.prepareStatement(sqlQuery);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                int id =resultSet.getInt("id");
                int month_count =resultSet.getInt("month_count");
                LongestProject client =new  LongestProject(id,month_count);
                result.add(client);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }public List<YoungestAndEldest>  findYungestAndEldest(){
        List<YoungestAndEldest> result=new ArrayList<>();
        String sqlFile ="./src/main/java/sql/find_youngest_eldest_workers.sql";
        String sqlQuery= readSqlFile(sqlFile);

        try {
            PreparedStatement statement= conn.prepareStatement(sqlQuery);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                String name =resultSet.getString("type");
                String salary =resultSet.getString("name");
                String birthday=resultSet.getString("birthday");
                YoungestAndEldest client =new  YoungestAndEldest(name,salary,birthday);
                result.add(client);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
}
    public List<ProjectPrice>  projectPrices(){
        List<ProjectPrice> result=new ArrayList<>();
        String sqlFile ="./src/main/java/sql/print_project_prices.sql";
        String sqlQuery= readSqlFile(sqlFile);

        try {
            PreparedStatement statement= conn.prepareStatement(sqlQuery);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                int id =resultSet.getInt("id");
                int price =resultSet.getInt("price");

                ProjectPrice client =new ProjectPrice(id,price);
                result.add(client);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }
    private String readSqlFile(String fileName) {
    StringBuilder content=new StringBuilder();
    try (BufferedReader br=new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            content.append(line).append("\n");

        }
    }catch (IOException e){
        e.printStackTrace();
    }
    return content.toString();
    }
public void clear(){
    try {
        conn.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public String  findWorker(int num){

        String sqlFile ="SELECT * FROM worker WHERE id = ?";
        String result = null;

        try {
            PreparedStatement statement = conn.prepareStatement(sqlFile);
            int value = num; // Значення, яке потрібно передати в запит
            statement.setInt(1, value);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Отримання значень з результату
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                 String birthday=resultSet.getString("birthday");
                 String level = resultSet.getString("level");
                 int salary =resultSet.getInt("salary");
 result="id ="+id+"\n"+"name ="+name+"\n"+"birthday ="+birthday+"\n"+"level ="+level+"\n"+"salary ="+salary;

                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;

    }
    }


