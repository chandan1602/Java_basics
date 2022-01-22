package com.example.crudproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectivity {
    public static Connection dbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            String url = "jdbc:mysql://localhost:3306/crudproject";
            conn = DriverManager.getConnection(url, "root", "12345$asdfg");
            System.out.println("Database Connected");
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
