package com.napier.sem;

import java.sql.*;



public class App {

    private Connection con = null;

    // Attempts to connect to the database.
    // Attempts it up to 10 times.
    // Throws error if thread is interrupted or SQL connection error occurs.
    public void Connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("SQL driver could not be loaded");
            System.exit(-1);
        }

        int tries = 10;
        for (int i = 0; i < tries; i++)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait for database to start
                Thread.sleep(30000);

                // Attempt connection to the database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/employees?useSSL=false", "root", "example");
                System.out.println("Successful connection");
                break;
            }
            catch (SQLException e)
            {
                System.out.println("Failed to connect to database on attempt number " + i);
                System.out.println(e.getMessage());
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted.");
            }
        }
    }

    // Severs connection from the database.
    // Throws an error if the connection could not be severed.
    public void Disconnect()
    {
        if (con != null)
        {
            try
            {
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database...");
            }
        }
    }

    public static void main(String[] args) {
        App a = new App();
        a.Connect();
        a.Disconnect();
    }
}
