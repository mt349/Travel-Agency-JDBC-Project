
import model.Bus;
import model.Passenger;
import dao.BusDAO;
import dao.PassengerDAO;
import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         BusDAO busDAO = new BusDAO();
         PassengerDAO passengerDAO = new PassengerDAO();

         boolean running = true;
         while(running) {
            System.out.println("---- TRAVEL AGENCY MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Bus : ");
            System.out.println("2. View All Buses : ");
            System.out.println("3. View Available Buses : ");
            System.out.println("4. Add Passenger : ");
            System.out.println("5. View All Passengers : ");
            System.out.println("6. View Passengers By Bus : ");
            System.out.println("7. Cancel Booking : ");
            System.out.println("8. Exit : ");
            System.out.println("Enter your Choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                
                case 1 :
                    System.out.println(" Enter Bus ID ");
                    int bus_ID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Bus Capacity : ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(" Bus is_Available :");
                    boolean is_Available = Boolean.parseBoolean(scanner.nextLine());
                    System.out.println("Enter Route : ");
                    String Route = scanner.nextLine();
                    System.out.println("Enter Departure Time (HH : mm : ss): ");
                    String timeInput = scanner.nextLine();
                    Time departureTime = Time.valueOf(timeInput);
                    try {
                        busDAO.addBus(new Bus(bus_ID, capacity, is_Available, Route, departureTime));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2 :
                    System.out.println("View All Buses : ");
                    try {
                    busDAO.getAllBus().forEach(bus -> bus.displayBusInfo());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3 :
                    System.out.println("Available Buses : ");
                    try {
                        busDAO.getAvailableBus().forEach(bus -> bus.displayBusInfo());
                    } catch(SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 4 :
                    System.out.println("Enter Passenger ID : ");
                    int passenger_ID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Name : ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Phone Number : ");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter Bus ID : ");
                    int busID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Seat Number : ");
                    int seatNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Booking Date : ");
                    Date booking_Date = new Date(System.currentTimeMillis());
                    try {
                        passengerDAO.addPassenger(new Passenger(passenger_ID, name, phoneNumber, busID, booking_Date, seatNumber));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 5 :
                    System.out.println("View All Passengers : ");
                    try {
                        passengerDAO.getAllPassengers().forEach(passenger -> passenger.displayPassengerInfo());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 6 :
                    System.out.println(" Enter Bus ID : ");
                    int busId = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        passengerDAO.getAllPassengersByBus(busId).forEach(passenger -> passenger.displayPassengerInfo());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 7 :
                    System.out.println("Enter Passenger ID to Cancel Booking : ");
                    int cancelID = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        passengerDAO.cancelBooking(cancelID);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 8 :
                    System.out.println("Exiting..........");
                    running = false;
                    break;
            }
         }
    } 

    
}
