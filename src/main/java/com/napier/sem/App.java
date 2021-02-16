package com.napier.sem;

import java.sql.*;

public class App {
    public static void main(String[] args) {

        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver.");
            System.exit(-1);
        }

        // Connection to the database
        Connection con = null;
        int retries = 100;
        for (int i = 0; i < retries; i++)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait for db to start
                Thread.sleep(3000);

                // Connect to the database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/employees?useSSL=false", "root", "example");
                System.out.println("Connection successful");

                // Wait...
                Thread.sleep(10000);

                // Break from loop
                break;
            }
            catch(SQLException sqle)
            {
                System.out.println("Failed to connect to database on attempt no. " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted.");
            }
        }

        if(con != null)
        {
            try
            {
                // Close the connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing database connection");
            }
        }

    }
}
