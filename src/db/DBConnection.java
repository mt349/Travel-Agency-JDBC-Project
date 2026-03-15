package db;
import java.sql.*;
import java.util.*;

public class DBConnection {
    
    private static final String url =  System.getenv("DB_URL");

    private static final String username = System.getenv("DB_USER");

    private static final String password = System.getenv("DB_PASS");

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Downloading essential Drivers
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(url,username,password);

    }

    
}
