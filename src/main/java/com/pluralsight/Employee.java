/*
The Employee class is used to store and calculate payroll information about an employee
 */
package com.pluralsight;

public class Employee {
    // Data fields
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double punchInTime;
    private double punchOutTime;

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

    // Methods
    // Each time the employee punched in, we track their start time
    public void punchIn(double time){
        this.punchInTime = time;
    }

    // When they punch out, we calculate how many hours they have worked and add that time
    // to their hours worked
    public  void punchOut(double time){
        this.punchOutTime = time;
            // if the punch out time is after the punch in time it will save the hours worked
            if(punchOutTime > punchInTime) {
                setHoursWorked(hoursWorked +(punchOutTime - punchInTime));
            }
            else{
                System.out.println("Your punch out time occurs before punch in time, please re-enter punch out time.");
            }
    }
}