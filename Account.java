/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_adam_hill;

/**
 *
 * @author Adam
 */
public abstract class Account {

    private double interest;//stores interest
    private double amount;//stores money
    private int id;//id for the account
    private static int nextID = 1;//make sure no id for accounts are the same

    /**
     *Constructor
     * @param interest stores the interest
     * @param amount stores the amount
     */
    public Account(double interest, double amount) {
        this.interest = interest;
        this.amount = amount;
        id = nextID;
        System.out.println("Your account ID is: " + id);
        updateID();
    }

    /**
     *updates the static variable nextID
     */
    public void updateID() {
        nextID++;

    }

    /**
     *gets the interest
     * @return interest value
     */
    public double getInterest() {
        return interest;
    }

    /**
     *sets the interest
     * @param interest sets interest
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     *gets the amount of money in account
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     *sets the amount of money for the account
     * @param amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     *gets the account id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *set the accounts id if needed
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

}
