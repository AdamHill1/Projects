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
public class CDAccount extends Account {

    private int years;
    private int currentYear = 0;

    /**
     *Constructor
     * @param years
     * @param interest
     * @param amount
     */
    public CDAccount(int years, double interest, double amount) {
        super(interest, amount);
        this.years = years;
    }

    /**
     *gets the years of the account
     * @return
     */
    public int getYears() {
        return years;
    }

    /**
     *gets the interest after a year if the current year is not passed the years on account
     */
    public void calculateInterestYearly1() {
        //check to make sure it doesn't go over years and calculate the interest
        if (this.currentYear < this.years) {
            this.setAmount((this.getAmount() * this.getInterest()) + this.getAmount());
            currentYear++;
        }
    }

}
