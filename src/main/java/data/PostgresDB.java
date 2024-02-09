package data;

import data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() {

        String connectionURL = "jdbc:postgresql://localhost:5432/granted";
        try {
            // Load driver's class file into memory at runtime
            Class.forName("org.postgresql.Driver");

            // Establish connection to database
            Connection con = DriverManager.getConnection(connectionURL, "postgres", "1234");

            return con;
        } catch (Exception e) {

            // Handle exception when program fails to connect
            System.out.println("Failed to connect to database: ");
            System.out.println(e.getMessage());

            return null;
        }
    }
}
