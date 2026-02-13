package com.connetdatabase;

import java.sql.*;
import java.util.Scanner;

public class EMP {

    static String url = "jdbc:postgresql://localhost:5432/school";
    static String user = "postgres";
    static String password = "root";

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, user, password);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Find Employee");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addEmployee(con, sc);
                    break;

                case 2:
                    updateEmployee(con, sc);
                    break;

                case 3:
                    findEmployee(con, sc);
                    break;

                case 4:
                    System.out.println(" Exiting...");
                    con.close();
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice");
            }
        }
    }

    // ================= ADD EMPLOYEE =================
    static void addEmployee(Connection con, Scanner sc) throws SQLException {

        String sql = "INSERT INTO student (id, student_name, email, gender) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email/course: ");
        String email = sc.nextLine();

        System.out.print("Enter gender: ");
        String gender = sc.nextLine();

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, email);
        ps.setString(4, gender);

        ps.executeUpdate();
        System.out.println(" Employee added successfully");
    }

    // ================= UPDATE EMPLOYEE =================
    static void updateEmployee(Connection con, Scanner sc) throws SQLException {

        String sql = "UPDATE student SET student_name=?, email=?, gender=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter id to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new name: ");
        String name = sc.nextLine();

        System.out.print("Enter new email/course: ");
        String email = sc.nextLine();

        System.out.print("Enter new gender: ");
        String gender = sc.nextLine();

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, gender);
        ps.setInt(4, id);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println(" Employee updated successfully");
        else
            System.out.println(" Employee not found");
    }

    // ================= FIND EMPLOYEE =================
    static void findEmployee(Connection con, Scanner sc) throws SQLException {

        String sql = "SELECT * FROM student WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);

        System.out.print("Enter id to find: ");
        int id = sc.nextInt();

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("\n--- Employee Details ---");
            System.out.println("ID     : " + rs.getInt("id"));
            System.out.println("Name   : " + rs.getString("student_name"));
            System.out.println("Email  : " + rs.getString("email"));
            System.out.println("Gender : " + rs.getString("gender"));
        } else {
            System.out.println(" Employee not found");
        }
    }
}
