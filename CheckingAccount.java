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
public class CheckingAccount extends Account {

    /**
     *Constructor
     * @param interest
     * @param amount
     */
    public CheckingAccount(double interest, double amount) {
        super(interest, amount);
    }

    /**
     *calculates the interest for this account and adds it back to the amount
     */
    public void calculateInterestMonthly1() {
        //calculates the month interest
        this.setAmount((this.getAmount() * this.getInterest()) +this.getAmount());
    }
}
