package dao;
import java.sql.*;
import java.util.*;
import model.Bus;
import db.DBConnection;

public class BusDAO {
    public void addBus(Bus bus) throws SQLException {
        String query = "INSERT INTO bus(bus_ID,Capacity,is_Available,Route,departure_time)VALUES(?,?,?,?,?)";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, bus.getBusID());
                preparedStatement.setInt(2, bus.getCapacity());
                preparedStatement.setBoolean(3, bus.isAvailable());
                preparedStatement.setString(4, bus.getRoute());
                preparedStatement.setTime(5, bus.getDepartureTime());
                preparedStatement.executeUpdate();
                System.out.println("Bus Added Successfully!");
            }
    }

    public List <Bus> getAllBus() throws SQLException {
        List <Bus> list = new ArrayList<>();
        String query = "SELECT * FROM bus";
        try(Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
                while(resultSet.next()) {
                    list.add(new Bus (
                        resultSet.getInt("bus_ID"),
                        resultSet.getInt("Capacity"),
                        resultSet.getBoolean("is_Available"),
                        resultSet.getString("Route"),
                        resultSet.getTime("departure_time")
                    ));
                }
             }
             return list;

    }

    public List <Bus> getAvailableBus() throws SQLException {
        List <Bus> list = new ArrayList<>();
        String query = "SELECT * FROM bus WHERE is_Available = true";
        try(Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
              ResultSet resultSet = statement.executeQuery(query)) {
                while(resultSet.next()) {
                    list.add(new Bus (
                        resultSet.getInt("bus_ID"),
                        resultSet.getInt("Capacity"),
                        resultSet.getBoolean("is_Available"),
                        resultSet.getString("Route"),
                        resultSet.getTime("departure_time")
                    ));
                }
              }
              return list;
    } 

    
}
