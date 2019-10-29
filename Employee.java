/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_adam_hill;

import java.text.DecimalFormat;

/**
 *
 * @author Adam
 */
public class Employee extends Person {

    private double salary;//stores salary

    /**
     *Constructor
     * @param salary
     * @param name
     * @param address
     */
    public Employee(double salary, String name, String address) {
        super(name, address);
        System.out.println("Your employee ID: " + this.getId());
        this.salary = salary;
    }

    /**
     *gets the salary
     * @return
     */
    public double getSalary() {
        return salary;
    }

    /**
     *sets the salary
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     *gets the employees monthly pay based of their salary
     */
    public void calculateMonthPay() {
        //calculates the monthly pay based off your salary and sets it to two decimal place output
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        double week = this.getSalary() / 12;
        System.out.println("Your pay for the month is: $" + df.format(week));
    }

    /**
     *prints all the employees info name and salary
     */
    public void printEmployee() {
        //prints out your data
        System.out.println(this.getName() + " your ID is: " + this.getId() + " and your salary is $" + this.getSalary());
    }
}
