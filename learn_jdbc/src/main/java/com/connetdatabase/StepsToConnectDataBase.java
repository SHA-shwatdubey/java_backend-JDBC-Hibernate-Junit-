package com.connetdatabase;
//  Package name (project ko organize karne ke liye)

import java.sql.Connection;
//  Database se connection banane ke liye

import java.sql.DriverManager;
//  Driver ke through connection create karta hai

import java.sql.SQLException;
//  JDBC errors handle karne ke liye

import java.sql.Statement;
//  SQL query execute karne ke liye

public class StepsToConnectDataBase {
//  Class start

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //  Program ka starting point
        //  throws isliye kyunki JDBC me error aa sakta hai

        String url = "jdbc:postgresql://localhost:5432/school";
        //  PostgreSQL ka address
        //  school = database name

        String user = "postgres";
        //  Database username

        String password = "root";
        //  Database password

        Class.forName("org.postgresql.Driver");
        //  PostgreSQL driver load karta hai
        //  Java ko batata hai kaunsa DB use karna hai

        System.out.println("Class Loaded");

        Connection con = DriverManager.getConnection(url, user, password);
        //  Java aur PostgreSQL ke beech connection ban gaya

        System.out.println("Connection Established");

        // insert-------------------------------------------------------------------------------------------

//        String sql = "INSERT INTO student VALUES (1012, 'Miller', 'shashwa@gmail.com', 'CSE')";
        String sql = "INSERT INTO student VALUES (1013, 'Abhishek', 'abhishek@gmail.com', 'ECE')";

        // --------------------------------------------------------------------------------------------------

        //  SQL INSERT query
        //  student table me data insert ho raha hai

        Statement stmt = con.createStatement();
        //  Statement object bana
        //  SQL query run karne ke kaam aata hai

        stmt.executeUpdate(sql);
        //  INSERT query execute hui
        //  executeUpdate() = INSERT / UPDATE / DELETE ke liye

        System.out.println("Data Inserted Successfully");

        stmt.close();
        //  Statement close (memory free)

        con.close();
        //  Database connection close
    }
}
