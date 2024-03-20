package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    private static Connection connection;
    public static final String DB_URL = "jdbc:mysql://localhost:3306/";

    public static Connection getConnection() {
        return connection;
    }

    public static void createConnection(String dbName, String user, String password) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        connection = DriverManager.getConnection(DB_URL,properties.getProperty("user")
                ,properties.getProperty("password"));
    }
}
