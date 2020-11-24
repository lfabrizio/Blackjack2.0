package com.fabrizio;

public class Dealer implements RetrieveInformation{
    private String name;
    private int employeeId;

    public Dealer(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public String getName() {
        return this.name;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}
