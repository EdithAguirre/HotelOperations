package com.pluralsight;

public class Employee {
    // Data fields
    private int employeeId;
    private String name;
    private String department;
    private float payRate;
    private float hoursWorked;

    // Constructor
    public Employee(int employeeId, String name, String department, float payRate, float hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Derived Getters
    public double getTotalPay(){
        return (hoursWorked * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    public float getRegularHours(){
        return hoursWorked;
    }

    public float getOvertimeHours(){
        return hoursWorked - 40;
    }

}
