/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package woffortune;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class that defines a player for a game with monetary winnings and 
 * a limited number of choices
 * @author clatulip and Adam Hill
 */
public class Player {
    private int winnings = 0; // amount of money won
    private String name; // player's name
    private int numGuesses = 0; // number of times they've tried to solve puzzle
    private ArrayList<String> prizes = new ArrayList<String>();//the prizes list
    private ArrayList<String> prizesWon = new ArrayList<String>();//the prizes won
    private int num;//stores the random num for the possible prize
    /**
     * Constructor
     * @param name String that is the player's name
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return int amount of money won so far 
     */
    public int getWinnings() {
        return winnings;
    }

    /**
     * Adds amount to the player's winnings
     * @param amount int money to add
     */
    public void incrementScore(int amount) {
        if (amount < 0) return;
        this.winnings += amount;
    }

    /**
     * Getter 
     * @return String player's name 
     */
    public String getName() {
        return name;
    }

    /**
     * Getter
     * @return int the number of guesses used up 
     */
    public int getNumGuesses() {
        return numGuesses;
    }

    /** 
     * Add 1 to the number of guesses used up
     */
    public void incrementNumGuesses() {
        this.numGuesses++;
    }
    
    /**
     * Resets for a new game (only number of guesses)
     * This does not reset the winnings.
     */
    public void reset() {
        this.numGuesses = 0;
    }
    
    /**
     *Resets the winnings of the player
     */
    public void bankrupt() {
        //gets rid of the players money
        this.winnings = 0;
    }

    /**
     *adds the prizes to the ArrayList prizes
     */
    public void prizeList(){
        //adds the prizes to the prizes array list
        prizes.add("A new Car!!");
        prizes.add("A vaction to Hawaii!!");
        prizes.add("A vacation to Bahamas!!");
        prizes.add("A new Computer!!");
    }
    
    /**
     *gets the potential prizes from the array list and stores random number
     */
    public void potentialPrize(){
        //get the the potential prizes and get random num for if they get the letter correct
        prizeList();
        Random r = new Random();
        num = r.nextInt(prizes.size());
        System.out.println("You have a chance to win " + prizes.get(num));
    }
    
    /**
     *Add the prizes to the prizesWon array list for the player
     */
    public void addPrize(){
        //add prizes for the player called on
        this.prizesWon.add(prizes.get(num));
        System.out.println("You won " + prizes.get(num));
    }
    
    /**
     *Gets what prizes the player has won
     */
    public void getPrizes(){
        //gets the prizes for the player called on
        for(int i = 0; i < prizesWon.size(); i++){
        System.out.print(prizesWon.get(i)+" ");
        } 
    }

    /**
     *Removes the prizes from prizesWon array list
     */
    public void removePrizes(){
        //clears the arraylist for the object called on
        this.prizesWon.clear();
    }
    
    /**
     *Gets the number of prizes won by a player
     * @return the number of prizes won
     */
    public int getSize(){
        //return the size of the arraylist for prizes
      return  this.prizesWon.size();
    }
    
}
