package org.example;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;

public class FlywayExample {
    public static void main(String[] args) {
        // Створення об'єкту Flyway та налаштування його параметрів
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:32768/modul1", "postgres", "1111")
                .locations("filesystem:src/main/resources/db/migration")
                .load();

        // Виконання міграцій бази даних

        flyway.migrate();
        // Виведення повідомлення про успішне виконання міграцій
        System.out.println("Міграції бази даних виконано успішно!");
    }
}