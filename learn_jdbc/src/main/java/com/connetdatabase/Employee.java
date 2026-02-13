package com.connetdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:postgresql://localhost:5432/school";
        String user = "postgres";
        String password = "root";

        // STEP 1: Load Driver
        Class.forName("org.postgresql.Driver");
        System.out.println("Class Loaded");

        // STEP 2: Establish Connection
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Connection Established");

        // STEP 3: SQL INSERT (employee table)
//        String sql = "INSERT INTO employee VALUES (1, 'Abhishek', 'abhishek@gmail.com', 'Male')";
//        String sql = "INSERT INTO employee VALUES (2, 'Shashwat', 'shashwat@gmail.com', 'Male')";
//        String sql = "INSERT INTO employee VALUES (3, 'Shubham', 'shubham@gmail.com', 'Male')";
//        String sql = "INSERT INTO employee VALUES (4, 'Arjit', 'arjit@gmail.com', 'Male')";
        String sql = "INSERT INTO employee VALUES (5, 'Dhiraj', 'dhiraj@gmail.com', 'Male')";


        // STEP 4: Create Statement
        Statement stmt = con.createStatement();

        // STEP 5: Execute Query
        stmt.executeUpdate(sql);
        System.out.println("Employee Data Inserted Successfully");

        // STEP 6: Close resources
        stmt.close();
        con.close();
    }
}
