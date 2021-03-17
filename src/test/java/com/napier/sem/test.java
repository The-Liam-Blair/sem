package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class test {
    static App app;

    // Runs before all tests
    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /*  --------------------
          DISPLAY SALARIES - printSalaries(ArrayList<Employee> Employees)
    */

    // Passes a null pointer to the method
    @Test
    void printSalariesTestNull()
    {
        app.printSalaries(null);
    }

    // Passes an empty array list to the method
    @Test
    void printSalariesTestEmpty()
    {
        ArrayList<Employee> Employees = new ArrayList<Employee>();
        app.printSalaries(Employees);
    }

    // Passes an array list with a null employee object inside
    @Test
    void printSalariesTestContainsNull()
    {
        ArrayList<Employee> Employees = new ArrayList<Employee>();
        Employees.add(null);
        app.printSalaries(Employees);
    }

    // Normal case: Tests method in normal conditions, no extremes tested.
    @Test
    void printSalaries()
    {
        ArrayList<Employee> Employees = new ArrayList<Employee>();
        Employee emp = new Employee();
        emp.emp_no = 1;
        emp.first_name = "Liam";
        emp.last_name = "Blair";
        emp.title = "Engineer";
        emp.salary = 55000;
        Employees.add(emp);
        app.printSalaries(Employees);
    }

    /*  --------------------
          DISPLAY EMPLOYEE - displayEmployee(Employee emp);
    */

    // Null test
    @Test
    void DisplayEmployeeNullTest()
    {
        app.displayEmployee(null);
    }

    // Empty array test
    @Test
    void DisplayEmployeeEmptyTest()
    {
        Employee emp = new Employee();
        app.displayEmployee(emp);
    }

    // Normal case test
    @Test
    void DisplayEmployee()
    {
        Employee emp = new Employee();
        emp.emp_no = 1;
        emp.first_name = "Liam";
        emp.last_name = "Blair";
        emp.title = "Engineer";
        emp.salary = 55000;
        app.displayEmployee(emp);
    }
}
