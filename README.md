# Travel Agency JDBC Project

A simple Java console application to manage buses and passenger bookings using **JDBC** and **MySQL**.

---

## **Features**

- Add a bus (auto-generates Bus ID)
- Add a passenger and assign to an existing bus
- Display buses and passengers in the console
- Prevents adding a passenger to a non-existent bus (foreign key enforcement)

---

## **Database Setup**

1. Create a database:

```sql
CREATE DATABASE travel_agency;
USE travel_agency;

CREATE TABLE bus (
    bus_ID INT AUTO_INCREMENT PRIMARY KEY,
    capacity INT NOT NULL,
    is_available BOOLEAN NOT NULL
);

CREATE TABLE passenger (
    passenger_ID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    bus_ID INT NOT NULL,
    booking_date DATE NOT NULL,
    FOREIGN KEY (bus_ID) REFERENCES bus(bus_ID)
);
