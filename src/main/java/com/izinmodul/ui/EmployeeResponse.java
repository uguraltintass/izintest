package com.izinmodul.ui;

public class EmployeeResponse {

    private double leaveBalance;
    //private String employee_name;

    public EmployeeResponse(double leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public EmployeeResponse() {
    }

    public double getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(double leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

}
