package postgres.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    // Instance variables
    private Connection connection;
    private String host = "localhost";
    private int port = 5432;
    private String databaseName = "postgres";
    private String user = "postgres";
    private String password;

    // Constructor
    public DatabaseManager() {}

    // Builder Methods
    public DatabaseManager host(String host) {
        this.host = host;
        return this;
    }

    public DatabaseManager port(int port) {
        this.port = port;
        return this;
    }

    public DatabaseManager databaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    public DatabaseManager user(String user) {
        this.user = user;
        return this;
    }

    public DatabaseManager password(String password) {
        this.password = password;
        return this;
    }

    // Methods
    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + databaseName, user, password);
                if (connection != null) {
                    System.out.println("Successfully connected to " + databaseName);
                } else {
                    System.out.println("Couldn't connect to " + databaseName);
                }
            } catch (Exception e) {
                System.out.println("An exception occurred while connecting to the database " + databaseName + ".\nError: " + e.getMessage());
            }
        }
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while closing the connection.\nError: " + e.getLocalizedMessage());
        }
    }

}
