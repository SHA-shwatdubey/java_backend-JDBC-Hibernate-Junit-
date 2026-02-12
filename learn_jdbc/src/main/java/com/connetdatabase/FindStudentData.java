package com.connetdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FindStudentData {

    public static void main(String[] args) {

        try {
            // STEP 1 : Load PostgreSQL Driver
            Class.forName("org.postgresql.Driver");

            // STEP 2 : Database details
            String url = "jdbc:postgresql://localhost:5432/school";
            String user = "postgres";
            String password = "root";

            // STEP 3 : Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);

            // STEP 4 : SQL SELECT query
            String sql = "SELECT * FROM student";

            // STEP 3 : Create Statement
            Statement stmt = con.createStatement();

            // STEP 6 : Execute SELECT query
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 7 : Fetch data row by row
            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4)
                );
            }

            // STEP 8️⃣ : Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
