package com.napier.sem;

import javax.xml.transform.Result;
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

    public Employee getEmployee(int ID)
    {
        try
        {
            // Statement object created
            Statement stmt = con.createStatement();

            // Query string created
            String strSelect =
                    "SELECT * "
                    + "FROM titles JOIN employees ON (titles.emp_no = employees.emp_no) " +
                            "JOIN dept_manager ON (employees.emp_no = dept_manager.emp_no"
                    + "WHERE emp_no = " + ID;

            // Execute query
            ResultSet rset = stmt.executeQuery(strSelect);

            // Output.
            // Returns database information represented as the Employee class if
            // a valid ID was found.
            if (rset.next())
            {
                Employee emp = new Employee();
                emp.emp_no = rset.getInt("employees.emp_no");
                emp.first_name = rset.getString("first_name");
                emp.last_name = rset.getString("last_name");

                if(rset.getString("title").equals("9999-01-01"))
                {
                    System.out.println("If statement passed");
                    emp.title = rset.getString("title");
                }
                else
                {
                    System.out.println("If statement failed.");
                    emp.title = rset.getString("title");
                }

                emp.salary = rset.getInt("salary");
                emp.dept_name = rset.getString("dept_name");

                int managerID = rset.getInt("dept_manager.emp_no");
                rset = stmt.executeQuery("SELECT first_name FROM employees WHERE emp_no = " + managerID);
                emp.manager = rset.getString("first_name");
                return emp;
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to retrieve employee details.");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void displayEmployee(Employee emp)
    {
        if (emp != null)
        {
            System.out.println(
                    emp.emp_no + " "
                    + emp.first_name + " "
                    + emp.last_name + "\n"
                    + emp.title + "\n"
                    + "Salary: "  + emp.salary + "\n"
                    + emp.dept_name + "\n"
                    + "Manager: " + emp.manager + "\n");
        }
    }

    public static void main(String[] args) {
        App a = new App();
        a.Connect();

        Employee emp = a.getEmployee(255530);
        a.displayEmployee(emp);

        a.Disconnect();
    }
}
