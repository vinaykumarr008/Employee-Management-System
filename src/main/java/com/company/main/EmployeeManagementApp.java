package com.company.main;

import com.company.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class EmployeeManagementApp {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
            case 1:
                addEmployee();
                break;
            case 2:
                viewEmployee();
                break;
            case 3:
                updateEmployee();
                break;
            case 4:
                deleteEmployee();
                break;
            case 5:
                System.out.println("Exiting program.");
                sessionFactory.close();
                return;
            default:
                System.out.println("Invalid choice. Try again.");
        }

        }
    }

    private static void addEmployee() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = new Employee();
        System.out.print("Enter Name: ");
        emp.setName(scanner.next());
        System.out.print("Enter Salary: ");
        emp.setSalary(scanner.nextDouble());
        System.out.print("Enter Designation: ");
        emp.setDesignation(scanner.next());
        System.out.print("Enter Department: ");
        emp.setDepartment(scanner.next());

        session.persist(emp);
        tx.commit();
        session.close();
        System.out.println("Employee added with ID: " + emp.getId());
    }

    private static void viewEmployee() {
        Session session = sessionFactory.openSession();
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        Employee emp = session.get(Employee.class, id);
        session.close();

        if (emp != null) {
            System.out.println("ID: " + emp.getId());
            System.out.println("Name: " + emp.getName());
            System.out.println("Salary: " + emp.getSalary());
            System.out.println("Designation: " + emp.getDesignation());
            System.out.println("Department: " + emp.getDepartment());
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void updateEmployee() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            System.out.print("Enter new Salary: ");
            emp.setSalary(scanner.nextDouble());
            System.out.print("Enter new Department: ");
            emp.setDepartment(scanner.next());

            session.update(emp);
            tx.commit();
            System.out.println("Employee updated.");
        } else {
            System.out.println("Employee not found.");
        }

        session.close();
    }

    private static void deleteEmployee() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            session.remove(emp);
            tx.commit();
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }

        session.close();
    }
}
