/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_adam_hill;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class Customer extends Person {

    private ArrayList<Account> accounts = new ArrayList<Account>();//stores the account for each employee

    /**
     *Constructor
     * @param name
     * @param address
     */
    public Customer(String name, String address) {
        super(name, address);
        System.out.println("Your customer ID: " + this.getId());
    }

    /**
     *makes new account based off your inputs
     * @param interest
     * @param amount
     * @param type
     */
    public void addAccount(double interest, double amount, int type) {
        int years = 0;
        boolean temp = true;//verification
        Scanner sc = new Scanner(System.in);
        switch (type) {
            //add to which account you choose
            case 0:
                accounts.add(new CheckingAccount(interest, amount));
                break;
            case 1:
                accounts.add(new SavingAccount(interest, amount));
                break;
            case 2:
                //verification
                while (temp) {
                    try {
                        System.out.println("Enter number of years: ");
                        years = sc.nextInt();
                        if (years > 0) {
                            temp = false;
                        }
                    } catch (InputMismatchException ie) {
                        System.out.println("Error!! Must be a number!!" + ie);
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("General exception caught: " + e);
                        sc.nextLine();
                    }
                    accounts.add(new CDAccount(years, interest, amount));
                    break;
                }
        }

    }

    /**
     *gets all the account for this customer
     * @return
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     *removes and account based off the id inputed
     * @param ID
     * @return
     */
    public boolean removeAccount(int ID) {
        boolean temp1 = false;//return variable
        for (Account a : accounts) {
            //verification and remove account if it matches
            if (a.getId() == ID) {
                this.accounts.remove(a);
                temp1 = true;
                break;
            }
        }
        return temp1;
    }

    /**
     *adds money to account based off id inputed
     * @param ID
     * @param Amount
     */
    public void addMoney(int ID, double Amount) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        //adds money if the account is there
        for (Account a : accounts) {
            if (a.getId() == ID) {
                a.setAmount(Amount + a.getAmount());
                System.out.println("You have $" + df.format(a.getAmount()) + " in your account.");
            }
        }
    }

    /**
     *removes money based of id inputed
     * @param ID
     * @param Amount
     */
    public void removeMoney(int ID, double Amount) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        //removes money if the account is there
        for (Account a : accounts) {
            if (a.getId() == ID) {
                //if amount asked is less than what is in the in the account the say error message
                if (a.getAmount() - Amount < 0) {
                    System.out.println("Dont have enough money: $" + df.format(a.getAmount()));
                    break;
                } else {
                    a.setAmount(a.getAmount() - Amount);
                    System.out.println("You have $" + df.format(a.getAmount()) + " left in your account.");
                }
            }
        }
    }

    /**
     *gets the money in account based of id inputed
     * @param ID
     * @return
     */
    public double getMoney(int ID) {
        return this.accounts.get(ID).getAmount();
    }

    /**
     *changes the interest based on the account id inputed
     * @param ID
     * @param interest
     */
    public void changeInterest(int ID, double interest) {
        this.accounts.get(ID).setInterest(interest);
    }

    /**
     * MAIN METHOD
     * calls the monthly interest method for all the account you have that are monthly 
     * interest
     */
    public void calculateInterestMonthly() {
        //calls all the accounts that have monthly interest and updates amount
        for (Account a : accounts) {
            if (a.getClass().toString().contains("SavingAccount")) {
                ((SavingAccount) a).calculateInterestMonthly1();
            }
            if (a.getClass().toString().contains("CheckingAccount")) {
                ((CheckingAccount) a).calculateInterestMonthly1();
            }
        }
    }

    /**
     * MAIN METHOD
     * Calls the monthly and interest method for all the account you have that are monthly 
     * and yearly interest calls monthly 12 times and yearly once
     */
    public void calculateInterestYearly() {
        //calls all the accounts that have monthly interest and updates amount
        for (int i = 0; i < 12; i++) {
            calculateInterestMonthly();
        }
        ////calls all the accounts that have yearly interest and updates amount
        for (Account a : accounts) {
            if (a.getClass().toString().contains("CDAccount")) {
                ((CDAccount) a).calculateInterestYearly1();
            }
        }
    }

    /**
     *prints all the accounts info for this customer
     */
    public void printAccount() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        //prints all of the accounts for this customer
        System.out.print(this.getName() + " your accounts are\n ");
        for (Account a : accounts) {
            System.out.println("Account ID: " + a.getId() + " Amount: " + df.format(a.getAmount()) + ", Interest: " + a.getInterest());
        }
    }

}
