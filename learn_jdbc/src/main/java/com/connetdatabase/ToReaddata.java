package com.connetdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ToReaddata {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:postgresql://localhost:5432/school";
        String user = "postgres";
        String password = "root";

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(url, user, password);

        String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";
        PreparedStatement pstm = con.prepareStatement(sql);

        System.out.print("Enter id: ");
        int id = sc.nextInt();
        sc.nextLine(); // 🔥 buffer clear

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter course: ");
        String course = sc.nextLine(); //  ab skip nahi hoga

        System.out.print("Enter gender: ");
        String gender = sc.nextLine();

        pstm.setInt(1, id);
        pstm.setString(2, name);
        pstm.setString(3, course);
        pstm.setString(4, gender);

        int rows = pstm.executeUpdate();

        if (rows > 0) {
            System.out.println(" Data inserted successfully");
        }

        con.close();
        sc.close();
    }
}
