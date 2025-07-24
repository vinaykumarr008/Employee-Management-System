# Employee Management System

A simple console-based Employee Management System built using **Java**, **Hibernate (ORM)**, and **MySQL**. This project allows basic CRUD operations such as:

- ✅ Add Employee  
- 📋 View Employee  
- ✏️ Update Employee  
- ❌ Delete Employee

---

## 🔧 Technologies Used

- Java 8 or above  
- Hibernate 5.6  
- MySQL 8.0  
- Maven (for dependency management)  
- Eclipse or any Java IDE  

---

## 📁 Project Structure

EmployeeManagementSystem/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/company/
│ │ │ ├── entity/
│ │ │ │ └── Employee.java
│ │ │ └── main/
│ │ │ └── EmployeeManagementApp.java
│ └── resources/
│ └── hibernate.cfg.xml
├── pom.xml
└── README.md

---

## 🗃️ Database Setup

Run the following SQL commands in MySQL:


## 🗃️ Database Setup

Run the following SQL commands in MySQL:


CREATE DATABASE CompanyDB;

USE CompanyDB;

CREATE TABLE employee (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  salary DOUBLE NOT NULL,
  designation VARCHAR(50) NOT NULL,
  department VARCHAR(50)
);


⚙️ How to Run
Clone or download the repository

Open the project in Eclipse or any IDE

Make sure MySQL is running and hibernate.cfg.xml has correct DB credentials

Run the EmployeeManagementApp.java file from your IDE

📌  Features
Uses Hibernate ORM to avoid SQL queries manually

Clean structure for beginners

Console-based UI

CRUD operations with Hibernate sessions
