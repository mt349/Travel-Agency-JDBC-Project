package model;
import java.sql.*;

public class Passenger {
    private int passenger_ID;
    private String name;
    private String phoneNumber;
    private int bus_ID;
    private Date bookingDate;
    private int seatNumber;

    public Passenger(int passenger_ID,String name,String phoneNumber,int bus_ID,Date bookingDate,int seatNumber) {
        this.passenger_ID = passenger_ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bus_ID = bus_ID;
        this.bookingDate = bookingDate;
        this.seatNumber = seatNumber;
    }

    public int getPassengerID() {
        return passenger_ID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getBusID() {
        return bus_ID;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void displayPassengerInfo() {
        System.out.println("Passenger ID : " + passenger_ID + " | Name : " + name + " | Phone Number : " + phoneNumber + " | Bus ID : " + bus_ID + " | Booking Date : " + bookingDate + " | Seat Number : " + seatNumber);
    }
    
}
