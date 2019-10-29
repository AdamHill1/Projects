/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_adam_hill;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class Bank {

    private String name;
    private String address;
    private ArrayList<Person> person = new ArrayList<Person>();

    /**
     *Constructor
     * @param name sets name
     * @param address sets address
     */
    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * MAIN METHOD
     *Runs the whole program and gets the inputs need for other method calls
     */
    public void start() {
        String n;//stores name for person arraylist
        String ad;//stores address for person arraylist
        int choose = 0;//your choice
        int type1 = 0;//type choosen
        int my = 0;//year skip choose
        boolean temp = true;//verification variable
        boolean stop = true;//verification variable
        Scanner sc = new Scanner(System.in);
        //loop to start
        while (stop) {
            //verification loop
            while (temp) {
                try {
                    //gets input to methods and checks to make sure input is correct
                    System.out.println("Welcome to " + this.name + " located at " + this.address);
                    System.out.println("Choose: \n"
                            + "0: Add a Person \n"
                            + "1: Remove a Person or Account\n"
                            + "2: Get a Person \n"
                            + "3: Print All \n"
                            + "4: To Quit");

                    choose = sc.nextInt();
                    if (!(choose == 0 || choose == 1 || choose == 2 || choose == 3 || choose == 4)) {
                        System.out.println("Error incorrect number!!");
                    } else {
                        temp = false;
                    }
                } catch (InputMismatchException ie) {
                    System.out.println("Error!! Must be a number!!" + ie);
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("General exception caught: " + e);
                    sc.nextLine();
                }
            }
            temp = true;
            //switch case to call what you choose
            switch (choose) {
                case 0:
                    //gets more inputs and verification
                    sc = new Scanner(System.in);
                    System.out.println("Please enter your name: ");
                    n = sc.nextLine();
                    sc.reset();
                    System.out.println("\nPlease enter your address: ");
                    ad = sc.nextLine();
                    while (temp) {
                        try {
                            System.out.println("\nPlease enter 0 for customer or 1 for employee: ");
                            type1 = sc.nextInt();
                            if (!(type1 == 0 || type1 == 1)) {
                                System.out.println("Error incorrect number!!");
                            } else {
                                temp = false;
                            }
                        } catch (InputMismatchException ie) {
                            System.out.println("Error!! Must be a number!!" + ie);
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("General exception caught: " + e);
                            sc.nextLine();
                        }
                    }
                    temp = true;
                    //calls the method to add a new person
                    addPerson(n, ad, type1);
                    //verification
                    while (temp) {
                        try {
                            //get input for time change
                            System.out.println("Please enter 1 to skip a month or 2 to skip a year");
                            my = sc.nextInt();
                            if (!(my == 1 || my == 2)) {
                                System.out.println("Error incorrect number!!");
                            } else {
                                temp = false;
                            }
                        } catch (InputMismatchException ie) {
                            System.out.println("Error!! Must be a number!!" + ie);
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("General exception caught: " + e);
                            sc.nextLine();
                        }
                    }
                    temp = true;
                    //calls the time skip methods
                    switch (my) {
                        case 1:
                            for (int i = 0; i < person.size(); i++) {
                                if (person.get(i).getClass().toString().contains("Customer")) {
                                    ((Customer) person.get(i)).calculateInterestMonthly();
                                }
                            }
                            break;
                        case 2:
                            for (int i = 0; i < person.size(); i++) {
                                if (person.get(i).getClass().toString().contains("Customer")) {
                                    ((Customer) person.get(i)).calculateInterestYearly();
                                }
                            }
                            break;
                    }
                    break;
                case 1:
                    //calls the remove method and call time skip
                    removePersonAccount();
                    //verification
                    while (temp) {
                        try {
                            System.out.println("Please enter 1 to skip a month or 2 to skip a year");
                            my = sc.nextInt();
                            if (!(my == 1 || my == 2)) {
                                System.out.println("Error incorrect number!!");
                            } else {
                                temp = false;
                            }
                        } catch (InputMismatchException ie) {
                            System.out.println("Error!! Must be a number!!" + ie);
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("General exception caught: " + e);
                            sc.nextLine();
                        }
                    }
                    temp = true;
                    switch (my) {
                        case 1:
                            for (int i = 0; i < person.size(); i++) {
                                if (person.get(i).getClass().toString().contains("Customer")) {
                                    ((Customer) person.get(i)).calculateInterestMonthly();
                                }
                            }
                            break;
                        case 2:
                            for (int i = 0; i < person.size(); i++) {
                                if (person.get(i).getClass().toString().contains("Customer")) {
                                    ((Customer) person.get(i)).calculateInterestYearly();
                                }
                            }
                            break;
                    }
                    break;
                case 2:
                    //calls get person method and skip time
                    getPerson();
                    //verification
                    while (temp) {
                        try {
                            System.out.println("Please enter 1 to skip a month or 2 to skip a year");
                            my = sc.nextInt();
                            if (!(my == 1 || my == 2)) {
                                System.out.println("Error incorrect number!!");
                            } else {
                                temp = false;
                            }
                        } catch (InputMismatchException ie) {
                            System.out.println("Error!! Must be a number!!" + ie);
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("General exception caught: " + e);
                            sc.nextLine();
                        }
                    }
                    temp = true;
                    switch (my) {
                        case 1:
                            for (int i = 0; i < person.size(); i++) {
                                if (person.get(i).getClass().toString().contains("Customer")) {
                                    ((Customer) person.get(i)).calculateInterestMonthly();
                                }
                            }
                            break;
                        case 2:
                            for (int i = 0; i < person.size(); i++) {
                                if (person.get(i).getClass().toString().contains("Customer")) {
                                    ((Customer) person.get(i)).calculateInterestYearly();
                                }
                            }
                            break;
                    }
                    break;

                case 3:
                    //print out the employees and customers
                    print();
                    break;
                case 4:
                    //stops the program
                    stop = false;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * MAIN METHOD
     *Adds a person to either a customer and employee depending on your input
     * also add a new account based on your choice. The employee will take in the salary passed in
     * @param n
     * @param ad
     * @param type
     */
    public void addPerson(String n, String ad, int type) {
        Scanner sc = new Scanner(System.in);
        double amount = 0;//salary variable
        double a = 0.0;//amount for account
        int acc = 0;//account you choice
        boolean temp = true;//verification
        double interest = 0.0;// interest for account
        //customer
        if (type == 0) {
            //add new customer to array list
            person.add(new Customer(n, ad));
            //verification
            while (temp) {
                try {
                    //you choose and calls the correct method
                    System.out.println("Choose: \n"
                            + "0: Savings Account \n"
                            + "1: Checking Account \n"
                            + "2: CD Account ");
                    acc = sc.nextInt();
                    if (!(acc == 0 || acc == 1 || acc == 2)) {
                        System.out.println("Error incorrect number!!");
                    } else {
                        temp = false;
                    }
                } catch (InputMismatchException ie) {
                    System.out.println("Error!! Must be a number!!" + ie);
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("General exception caught: " + e);
                    sc.nextLine();
                }
            }
            temp = true;
            //verification
            while (temp) {
                try {
                    //gets inputs for the method call to add an account
                    System.out.println("Please enter the amount to put in the account: ");
                    a = sc.nextDouble();
                    if (a < 0.0 || interest < 0.0) {
                        System.out.println("Error incorrect number!!");
                    } else {
                        temp = false;
                    }
                } catch (InputMismatchException ie) {
                    System.out.println("Error!! Must be a number!!" + ie);
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("General exception caught: " + e);
                    sc.nextLine();
                }
            }
            temp = true;
            //verification
            while (temp) {
                try {
                    System.out.println("Please enter the interest for the account in percent: ");
                    interest = sc.nextDouble() / 100;
                    if (a < 0.0 || interest < 0.0) {
                        System.out.println("Error incorrect number!!");
                    } else {
                        temp = false;
                    }
                } catch (InputMismatchException ie) {
                    System.out.println("Error!! Must be a number!!" + ie);
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("General exception caught: " + e);
                    sc.nextLine();
                }
            }
        
        temp = true;
        //adds the inputs to make a new account
        ((Customer) person.get(person.size() - 1)).addAccount(interest, a, acc);
        a = 0;
        amount = 0;
        acc = 0;
        interest = 0;
        temp = true;
        }
        //employee
        if (type == 1) {
            boolean test = true;
            //verification
            while (test) {
                try {
                    //gets input for constructor
                    System.out.println("Enter your salary: $");
                    amount = sc.nextDouble();
                    if (amount > 0.0) {
                        test = false;
                    }
                } catch (InputMismatchException ie) {
                    System.out.println("Error!! Must be a number and be greater than 0!!" + ie);
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("General exception caught: " + e);
                    sc.nextLine();
                }
                //calls the constructor
                person.add(new Employee(amount, n, ad));

            }
        }
    }

    /**
     * MAIN METHOD
     *Removes either an account chosen or removes the person chosen.
     * Can remove both customers and employees.
     */
    public void removePersonAccount() {
        Scanner sc = new Scanner(System.in);
        int idtemp = 0;
        int type = 0;
        int temp = 0;
        boolean test = true;
        boolean test2 = false;
        boolean test3 = false;
        //verification
        while (test) {
            try {
                //choose to remove a person or an account
                System.out.println("Please enter 1 for Person or 2 for Account: ");
                type = sc.nextInt();
                if (!(type == 1 || type == 2)) {
                    System.out.println("Error incorrect number!!");
                } else {
                    test = false;
                }

            } catch (InputMismatchException ie) {
                System.out.println("Error!! Must be a number!!" + ie);
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("General exception caught: " + e);
                sc.nextLine();
            }
        }
        test = true;
        //verification
        while (test) {
            try {
                //get inputs for the method calls and verification
                System.out.println("Please enter your ID: ");
                idtemp = sc.nextInt();
                if (idtemp >= 0) {
                    test = false;
                }
            } catch (InputMismatchException ie) {
                System.out.println("Error!! Must be a number!!" + ie);
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("General exception caught: " + e);
                sc.nextLine();
            }
        }
        //removes a person from array list
        if (type == 1) {
            for (Person a : person) {
                if (a.getId() == idtemp) {
                    person.remove(a);
                    test2 = true;
                    System.out.println("Person removed.");
                    break;
                }
            }
        
        //verification and tells in put is wrong
        if (test2 == false) {
            System.out.println("Could not find you ID!!");
        }
        }
        //gets account id and removes the id
        if (type == 2) {
            System.out.println("What is your Account ID: ");
            temp = sc.nextInt();
            for (Person p : person) {
                if (p.getId() == idtemp) {
                    test3 = ((Customer) p).removeAccount(temp);
                    break;
                }
            }
        
        //tells what has happened
        if (test3 == true) {
            System.out.println("Account removed.");
        } else {
            System.out.println("Could not find Account with that ID!!!");
        }
        }

    }

    /**
     * MAIN METHOD
     * Gets a person by id and the ask if you want to deposit, withdraw, or add a new 
     * account for customer. For employees they get their months pay or set pay for employee
     */
    public void getPerson() {
        int type = 0;// tell your choose
        Scanner sc = new Scanner(System.in);
        boolean temp = true;//verification
        int acc= 0;//stores which account choosen
        double a = 0;//stores money
        double interest = 0;//stores interest
        //verification
        while (temp) {
            try {
                //gets your choose and verification
                System.out.println("Please enter 0 for customer or 1 for employee: ");
                type = sc.nextInt();
                if (!(type == 0 || type == 1)) {
                    System.out.println("Error incorrect number!!");
                } else {
                    temp = false;
                }
            } catch (InputMismatchException ie) {
                System.out.println("Error!! Must be a number!!" + ie);
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("General exception caught: " + e);
                sc.nextLine();
            }
        }

        if (type == 0) {
            temp = true;
            System.out.println("Please enter your ID: ");
            int id = sc.nextInt();
            for (Person p : person) {
                if (p.getId() == id) {
                    //gets options
                    System.out.println("Hello, " + p.getName());
                    System.out.println("Please enter 0 for deposit, 1 for withdraw, or 2 for add a new account: ");
                    int cash = sc.nextInt();
                    switch(cash){
                        case 0:   deposit(id);
                        break;
                        case 1: 
                        withdraw(id);
                        break;
                        case 2:
                            //verification and adds a new account
                            temp = true;
                        while (temp) {
                try {
                    //gets choose and verification
                    System.out.println("Choose: \n"
                            + "0: Savings Account \n"
                            + "1: Checking Account \n"
                            + "2: CD Account ");
                    acc = sc.nextInt();
                    if (!(acc == 0 || acc == 1 || acc == 2)) {
                        System.out.println("Error incorrect number!!");
                    } else {
                        temp = false;
                    }
                } catch (InputMismatchException ie) {
                    System.out.println("Error!! Must be a number!!" + ie);
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("General exception caught: " + e);
                    sc.nextLine();
                }
            }
            temp = true;
            //verification
            while (temp) {
                try {
                    //gets inputs for method call
                    System.out.println("Please enter the amount to put in the account: ");
                    a = sc.nextDouble();
                    if (a < 0.0 || interest < 0.0) {
                        System.out.println("Error incorrect number!!");
                    } else {
                        temp = false;
                    }
                } catch (InputMismatchException ie) {
                    System.out.println("Error!! Must be a number!!" + ie);
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("General exception caught: " + e);
                    sc.nextLine();
                }
            }
            temp = true;
            //verification
            while (temp) {
                try {
                    System.out.println("Please enter the interest for the account in percent: ");
                    interest = sc.nextDouble() / 100;
                    if (a < 0.0 || interest < 0.0) {
                        System.out.println("Error incorrect number!!");
                    } else {
                        temp = false;
                    }
                } catch (InputMismatchException ie) {
                    System.out.println("Error!! Must be a number!!" + ie);
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("General exception caught: " + e);
                    sc.nextLine();
                }
                //finds the person and adds a new account
                for(Person s: person){
                    if(s.getId() == id){
                        ((Customer)s).addAccount(interest, a, acc);
                    }
                }
            }break;
                    }
                }
            }
        }
        //employee
        else {
            System.out.println("Please enter your ID: ");
            int id1 = sc.nextInt();
            int pay;
            double sal = 0.0;
            System.out.println("Enter 1 for get months pay or enter 2 to set new salary");
            pay = sc.nextInt();
            for (Person p : person) {
                if (pay == 1) {
                    if (p.getId() == id1) {
                        System.out.println("Hello, " + p.getName());
                        getEmpPay(id1);
                    }
                }
                if (pay == 2) {
                    System.out.println("Please enter your new salary: $");
                    sal = sc.nextDouble();
                    ((Employee) p).setSalary(sal);
                    System.out.println("Your new salay is $" + ((Employee) p).getSalary());
                }
            }
        }

    }

    /**
     * MAIN METHOD
     *  Takes your inputs to add money to an account
     * @param id
     */
    public void deposit(int id) {
        boolean test = true;//verification
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your account ID: ");
        int accID = sc.nextInt();
        //verification
        while (test) {
            //checks the id and the ask how much you are depositing
            for (Person p : person) {
                if (p.getId() == id) {
                    System.out.println("Please enter the amount you are depositing: ");
                    double amount = sc.nextDouble();
                    boolean test2 = true;
                    //verification
                    while (test2) {
                        //if money is correct add if not the display error
                        if (amount > 0.0) {
                            ((Customer) p).addMoney(accID, amount);
                            test2 = false;
                            test = false;
                        } else {
                            System.out.println("Please enter an amount greater than 0.0: ");
                            amount = sc.nextDouble();
                        }
                    }
                } else {
                    System.out.println("Could not find Person ID!!");
                    break;
                }

            }
        }
    }

    /**
     * MAIN METHOD
     * Takes your input to take money out out of your account and if the amount is greater than amount 
     * in the account then stops it and tells the amount in account
     * @param id
     */
    public void withdraw(int id) {
        boolean test = true;//verification
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your account ID: ");
        int accID = sc.nextInt();
        //verification
        while (test) {
            //loops through and checks id then ask the amount to withdraw
            for (Person p : person) {
                if (p.getId() == id) {
                    System.out.println("Please enter the amount you are withdrawing: ");
                    double amount = sc.nextDouble();
                    boolean test2 = true;
                    while (test2) {
                        ((Customer) p).removeMoney(accID, amount);
                        test2 = false;
                        test = false;
                    }
                }
            }
        }

    }

    /**
     * Gets the employees pay by id
     * @param id
     */
    public void getEmpPay(int id2) {
        //gets the employee monthly pay
        boolean test = true;
        for (Person p : person) {
            if (((Employee) p).getId() == id2) {
                ((Employee) p).calculateMonthPay();
            } else {
                test = false;
            }
        }
        if(test = false){
            System.out.println("Could not find and employee with that ID!!!!");
        }
    }

    /**
     *prints out the customer and employee info
     */
    public void print() {
        //loops through empolyee and customer to print
        for (int i = 0; i < person.size(); i++) {
            if (person.get(i).getClass().toString().contains("Employee")) {
                ((Employee) person.get(i)).printEmployee();
            }
            if (person.get(i).getClass().toString().contains("Customer")) {
                ((Customer) person.get(i)).printAccount();
            }
        }
    }

    
    
}
