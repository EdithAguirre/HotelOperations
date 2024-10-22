/*
The Employee class is used to store and calculate payroll information about an employee
 */
package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Employee {
    // Data fields
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double punchInTime;
    private double punchOutTime;
    private LocalDateTime punchInLocalTime;
    private LocalDateTime punchOutLocalTime;

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

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Derived Getters
    public double getTotalPay(){
        // If the employee worked fewer hours than their regular hours
        if(hoursWorked < 40) {
            return (hoursWorked * payRate);
        }
        // total pay working regular hours (with overtime if applicable)
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    public double getRegularHours(){
        return 40;
    }

    public double getOvertimeHours(){
        if(hoursWorked - 40 <= 0){
            return 0;
        }
        return  (hoursWorked - 40);
    }

    // Overloaded method (parameterless)
    public void punchTimeCard(){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        if(punchInLocalTime == null && punchOutLocalTime == null) {
            punchInLocalTime = LocalDateTime.now();
        }
        else if(punchOutLocalTime == null){
            punchOutLocalTime = LocalDateTime.now();
            if(punchOutLocalTime.isAfter(punchInLocalTime)){
                setHoursWorked(hoursWorked + (punchInLocalTime.until(punchOutLocalTime, ChronoUnit.HOURS)));
                punchInLocalTime = null;
                punchOutLocalTime = null;
            }
            else{
                System.out.println("Your punch out time occurs before punch in time, please re-enter punch out time.");
            }
        }
    }

    // Single method to handle punch in and punch out (with a parameter)
    public void punchTimeCard(double time){
        // if there is no punch in time registered, store it
        if(punchInTime == 0 && punchOutTime == 0){
            punchInTime = time;
        // if there is a punch in time but no punch out time, store it and add hours worked
        } else if(punchOutTime == 0) {
            punchOutTime = time;
            if (punchOutTime > punchInTime) {
                setHoursWorked(hoursWorked + (punchOutTime - punchInTime));
                punchInTime = 0;
                punchOutTime = 0;
            } else {
                System.out.println("Your punch out time occurs before punch in time, please re-enter punch out time.");
            }
        }
    }


}