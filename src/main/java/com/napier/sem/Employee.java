package com.napier.sem;

// Class that stores the employee template. Used to extract employee information
// from the database.
public class Employee {

    public int emp_no;
    public String first_name;
    public String last_name;

    public String title;
    public int salary;

    public String dept_name;
    public Employee manager;
    public Department dept;
}
