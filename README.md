# 🚌 Travel Agency Management System

A Java console application to manage buses and passenger bookings using **JDBC**, **MySQL**, and a clean **DAO (Data Access Object) architecture**.

---

## 🚀 Features

- ➕ Add Bus
- 📋 View All Buses
- ✅ View Available Buses
- ➕ Add Passenger
- 📋 View All Passengers
- 🔍 View Passengers by Bus
- ❌ Cancel Booking
- 🚪 Exit

---

## 🛠️ Tech Stack

- **Java** — Core application logic
- **MySQL** — Database
- **JDBC** — Java Database Connectivity (MySQL Connector/J)

---

## 📁 Project Structure

```
src/
├── Main.java              ← Main menu & entry point
├── db/
│   └── DBConnection.java  ← Database connection handler
├── model/
│   ├── Bus.java           ← Bus data model
│   └── Passenger.java     ← Passenger data model
└── dao/
    ├── BusDAO.java        ← Bus database operations
    └── PassengerDAO.java  ← Passenger database operations
```

---

## ⚙️ Setup & Installation

### 1. Clone the repository
```bash
git clone https://github.com/mt349/Travel-Agency-JDBC-Project.git
cd Travel-Agency-JDBC-Project
```

### 2. Set up the MySQL Database
```sql
CREATE DATABASE travel_agency;
USE travel_agency;

CREATE TABLE bus (
    bus_ID INT PRIMARY KEY,
    Capacity INT NOT NULL,
    is_Available BOOLEAN NOT NULL,
    Route VARCHAR(100),
    departure_time TIME
);

CREATE TABLE passenger (
    passenger_ID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    phone_Number VARCHAR(20),
    booking_Date DATE,
    Seat_Number INT,
    bus_ID INT,
    FOREIGN KEY (bus_ID) REFERENCES bus(bus_ID)
);
```

### 3. Set Environment Variables
```bash
# Windows
set DB_URL=jdbc:mysql://localhost:3306/travel_agency
set DB_USER=your_username
set DB_PASS=your_password

# Mac/Linux
export DB_URL=jdbc:mysql://localhost:3306/travel_agency
export DB_USER=your_username
export DB_PASS=your_password
```

### 4. Add MySQL Connector/J
- Download from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
- Place the `.jar` file in the `lib/` folder
- Add it to your classpath in VS Code via `Ctrl+Shift+P` → **Java: Configure Classpath**

### 5. Compile & Run
```bash
# Windows
javac -cp .;lib/mysql-connector-j-x.x.x.jar src/*.java src/db/*.java src/model/*.java src/dao/*.java
java -cp .;lib/mysql-connector-j-x.x.x.jar Main

# Mac/Linux (replace ; with :)
javac -cp .:lib/mysql-connector-j-x.x.x.jar src/*.java src/db/*.java src/model/*.java src/dao/*.java
java -cp .:lib/mysql-connector-j-x.x.x.jar Main
```

---

## 📸 Usage

```
---- TRAVEL AGENCY MANAGEMENT SYSTEM ---
1. Add Bus
2. View All Buses
3. View Available Buses
4. Add Passenger
5. View All Passengers
6. View Passengers By Bus
7. Cancel Booking
8. Exit
Enter your Choice:
```

---

## 🏗️ Architecture

This project follows the **DAO (Data Access Object)** pattern:

- **Model layer** — Plain Java classes representing data (Bus, Passenger)
- **DAO layer** — Handles all database queries, keeping SQL out of main logic
- **DB layer** — Single class managing the database connection
- **Main class** — Only handles user input and calls DAO methods

---

## 🙋‍♀️ Author

Built by **Mahnoor Tariq (mt349)** — refactored from single-file JDBC to full DAO architecture 💪

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
