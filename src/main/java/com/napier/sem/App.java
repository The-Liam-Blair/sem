package com.napier.sem;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;



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
                    "SELECT employees.emp_no, first_name, last_name, title, salary "
                    + "FROM titles JOIN employees ON (titles.emp_no = employees.emp_no) " +
                            "JOIN salaries ON (employees.emp_no = salaries.emp_no) "
                    + "WHERE employees.emp_no = " + ID;

            // Execute query
            ResultSet rset = stmt.executeQuery(strSelect);

            // Output.
            // Returns database information represented as the Employee class if
            // a valid ID was found.
            Employee emp = new Employee();
            if (rset.next())
            {
                emp.emp_no = rset.getInt("employees.emp_no");
                emp.first_name = rset.getString("first_name");
                emp.last_name = rset.getString("last_name");
                emp.title = rset.getString("title");
                emp.salary = rset.getInt("salary");
            }
            else
            {
                return null;
            }
            return emp;
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
                    + "Salary: "  + emp.salary + "\n");
        }
    }

    public ArrayList<Employee> getAllSalaries()
    {
        try
        {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT employees.emp_no, employees.first_name, employees.last_name, salaries.salary "
                    + "FROM employees, salaries "
                    + "WHERE employees.emp_no = salaries.emp_no AND salaries.to_date = '9999-01-01' "
                    + "ORDER BY employees.emp_no ASC";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Employee> Employees = new ArrayList<>();

            while (rset.next())
            {
                Employee tempEmp = new Employee();
                tempEmp.emp_no = rset.getInt("employees.emp_no");
                tempEmp.first_name = rset.getString("employees.first_name");
                tempEmp.last_name = rset.getString("employees.last_name");
                tempEmp.salary = rset.getInt("salaries.salary");
                Employees.add(tempEmp);
            }
            return Employees;
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve salary details");
            return null;
        }
    }

    public ArrayList<Employee> GetSalaryByRole(String role)
    {
        try
        {
            Statement stmt = con.createStatement();
            String strSelect = "SELECT employees.emp_no, employees.first_name, employees.last_name, salaries.salary "
                    + "FROM employees, salaries, titles "
                    + "WHERE employees.emp_no = salaries.emp_no "
                    + "AND employees.emp_no = titles.emp_no "
                    + "AND salaries.to_date = '9999-01-01' "
                    + "AND titles.title = '" + role + "' "
                    + "ORDER BY employees.emp_no ASC";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Employee> Employees = new ArrayList<>();

            while (rset.next())
            {
                Employee tempEmp = new Employee();
                tempEmp.emp_no = rset.getInt("employees.emp_no");
                tempEmp.first_name = rset.getString("employees.first_name");
                tempEmp.last_name = rset.getString("employees.last_name");
                tempEmp.salary = rset.getInt("salaries.salary");
                Employees.add(tempEmp);
            }
            return Employees;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve salary details");
            return null;
        }
    }
    public void printSalaries(ArrayList<Employee> Employees)
    {
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Emp no", "First Name", "Last Name", "Salary"));
        for (Employee emp : Employees)
        {
            String emp_string = String.format("%-10s %-15s %-20s %-8s", emp.emp_no, emp.first_name, emp.last_name, emp.salary);
            System.out.println(emp_string);
        }
    }

    public static void main(String[] args) {
        App a = new App();
        a.Connect();
        ArrayList<Employee> Employees = a.GetSalaryByRole("Engineer");
        a.printSalaries(Employees);
        a.Disconnect();
    }
}
