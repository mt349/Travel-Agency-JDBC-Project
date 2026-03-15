package model;
import java.sql.*;

public class Bus {
    private int bus_ID;
    private int capacity;
    private boolean is_Available;
    private String route;
    private Time departure_time;

    public Bus(int bus_ID,int capacity,boolean is_Available,String route,Time departure_time) {
        this.bus_ID = bus_ID;
        this.capacity = capacity;
        this.is_Available = is_Available; //default
        this.route = route;
        this.departure_time = departure_time;
    }

    public int getBusID() {
        return bus_ID;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return is_Available;
    }

    public String getRoute() {
        return route;
    }

    public Time getDepartureTime() {
        return departure_time;
    }

    public void displayBusInfo() {
        System.out.println("Bus ID : " + bus_ID + " | Capacity : " + capacity + " | is_Available : " + is_Available + " | Route : " + route + " | Departure Time : " + departure_time);
    }
    
}
