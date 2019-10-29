/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_adam_hill;

import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class Assignment3_Adam_Hill {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String name;//stores name for constructor 
        String address;//stores address for constructor
        Bank b;
        //gets inputs for constructor
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your banks name: ");
        name = sc.nextLine();
        System.out.println("Please enter your banks address: ");
        address = sc.nextLine();
        //calls bank object and starts the program
        b = new Bank(name, address);
        b.start();

    }

}
