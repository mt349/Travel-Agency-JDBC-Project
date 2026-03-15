package dao;
import model.Passenger;
import db.DBConnection;
import java.sql.*;
import java.util.*;

public class PassengerDAO {
    public void addPassenger(Passenger passenger) throws SQLException {
        String query = "INSERT INTO passenger(passenger_ID,Name,phone_Number,booking_Date,Seat_Number,bus_ID)VALUES(?,?,?,?,?,?)";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, passenger.getPassengerID());
                preparedStatement.setString(2, passenger.getName());
                preparedStatement.setString(3, passenger.getPhoneNumber());
                preparedStatement.setDate(4, passenger.getBookingDate());
                preparedStatement.setInt(5, passenger.getSeatNumber());
                preparedStatement.setInt(6, passenger.getBusID());
                preparedStatement.executeUpdate();
                System.out.println("Passenger added Successfully!");
            }
    }

    public List <Passenger> getAllPassengers() throws SQLException {
        List <Passenger> list = new ArrayList<>();
        String query = "SELECT * FROM passenger";
        try (Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {
            while(resultSet.next()) {
                list.add(new Passenger(
                    resultSet.getInt("passenger_ID"),
                    resultSet.getString("name"),
                    resultSet.getString("phone_Number"),
                    resultSet.getInt("bus_ID"),
                    resultSet.getDate("booking_Date"),
                    resultSet.getInt("Seat_Number")
                ));
            }
        }
        return list;
    }

    public List <Passenger> getAllPassengersByBus(int bus_ID) throws SQLException {
        List <Passenger> list = new ArrayList<>();
        String query = "SELECT * FROM passenger WHERE bus_ID = ?";
        try(Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, bus_ID);
                   ResultSet resultSet = preparedStatement.executeQuery();
                   while(resultSet.next()) {
                    list.add(new Passenger(
                        resultSet.getInt("passenger_ID"),
                        resultSet.getString("name"),
                        resultSet.getString("phone_Number"),
                        resultSet.getInt("bus_ID"),
                        resultSet.getDate("booking_Date"),
                        resultSet.getInt("Seat_Number")
                    ));
                   }
                }
                return list;
        
    }

    public void cancelBooking(int passenger_ID) throws SQLException {
        String query = "DELETE FROM passenger WHERE passenger_ID = ?";
        try(Connection connection = DBConnection.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, passenger_ID);
            preparedStatement.executeUpdate();
            System.out.println("Booking Cancelled Successfully!");
           }
    }
    
}
