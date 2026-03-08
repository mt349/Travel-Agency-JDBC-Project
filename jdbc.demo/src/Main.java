import java.sql.*;
import java.util.Scanner;

class Bus {
    private int bus_ID;
    private int capacity;
    private boolean is_Available;

    public Bus(int bus_ID, int capacity, boolean is_Available) {
        this.bus_ID = bus_ID;
        this.capacity = capacity;
        this.is_Available = is_Available;
    }

    public int getBusID() {  return bus_ID; }
    public int getCapacity() { return capacity; }
    public boolean isAvailable() { return is_Available; }

    public void displayBusInfo() {
        System.out.println("BUS ID: " + bus_ID + " | CAPACITY: " + capacity + " | AVAILABLE: " + is_Available);
    }
}

class Passenger {
    private int passenger_ID;
    private String name;
    private int bus_ID;
    private Date booking_date;

    public Passenger(int passenger_ID, String name, int bus_ID, Date booking_date) {
        this.passenger_ID = passenger_ID;
        this.name = name;
        this.bus_ID = bus_ID;
        this.booking_date = booking_date;
    }

    public void displayPassengerInfo() {
        System.out.println("Passenger ID: " + passenger_ID + " | NAME: " + name + " | Bus ID: " + bus_ID + " | Booking Date: " + booking_date);
    }
}

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/travel_agency";
    private static final String username = "root";
    private static final String password = "coderMT91268";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("----TRAVEL AGENCY----");
            System.out.println("1. Add Bus");
            System.out.println("2. Add Passenger");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter Capacity: ");
                int capacity = scanner.nextInt();
                System.out.print("Is Available (true/false): ");
                boolean isAvailable = scanner.nextBoolean();

                String query = "INSERT INTO bus (capacity, is_available) VALUES (?, ?)";
                PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, capacity);
                ps.setBoolean(2, isAvailable);
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int generatedBusID = rs.getInt(1);
                    System.out.println("Bus added successfully! Generated Bus ID: " + generatedBusID);
                }

            } else if (choice == 2) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                // Show existing buses to avoid foreign key errors
                System.out.println("Available Buses:");
                Statement stmt = connection.createStatement();
                ResultSet rsBus = stmt.executeQuery("SELECT bus_ID, capacity, is_available FROM bus");
                while (rsBus.next()) {
                    System.out.println("Bus ID: " + rsBus.getInt("bus_ID") +
                            " | Capacity: " + rsBus.getInt("capacity") +
                            " | Available: " + rsBus.getBoolean("is_available"));
                }

                System.out.print("Enter Bus ID to book: ");
                int bus_ID = scanner.nextInt();
                Date bookingDate = new Date(System.currentTimeMillis());

                // Check if Bus ID exists
                String checkQuery = "SELECT bus_ID FROM bus WHERE bus_ID = ?";
                PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
                checkStmt.setInt(1, bus_ID);
                ResultSet checkRs = checkStmt.executeQuery();

                if (!checkRs.next()) {
                    System.out.println("Error: Bus ID does not exist! Cannot add passenger.");
                } else {
                    String insertQuery = "INSERT INTO passenger (name, bus_ID, booking_date) VALUES (?, ?, ?)";
                    PreparedStatement ps = connection.prepareStatement(insertQuery);
                    ps.setString(1, name);
                    ps.setInt(2, bus_ID);
                    ps.setDate(3, bookingDate);
                    ps.executeUpdate();

                    System.out.println("Passenger added successfully!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}