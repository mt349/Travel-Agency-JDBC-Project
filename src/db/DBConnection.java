package db;
import java.sql.*;
import java.util.*;

public class DBConnection {
    
    private static final String url = "jdbc:mysql://localhost:3306/travel_agency";

    private static final String username = "root";

    private static final String password = "coderMT91268";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Downloading essential Drivers
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(url,username,password);

    }

    
}
