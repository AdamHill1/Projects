/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package woffortune;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * WofFortuneGame class
 * Contains all logistics to run the game
 * @author clatulip and Adam Hill
 */
public class WofFortuneGame {

    private boolean puzzleSolved = false;

    private Wheel wheel;
    private Player player1;
    private String phrase = "Once upon a time";
    //private Letter[] letter_array = new Letter[16];
    private ArrayList<Letter> phrases_letters = new ArrayList<Letter>();
    private ArrayList<String> setPhrases = new ArrayList<String>();
    private ArrayList<Player> newPlayers = new ArrayList<Player>();
    

    /**
     * Constructor
     * @param wheel Wheel 
     * @throws InterruptedException 
     */
    public WofFortuneGame(Wheel wheel) throws InterruptedException {
        // get the wheel
        this.wheel = wheel;
        
        // do all the initialization for the game
        setUpGame();
        

    }
    
    /**
     * Plays the game
     * @throws InterruptedException 
     */
    public void playGame() throws InterruptedException {
        // while the puzzle isn't solved, keep going
        while (!puzzleSolved){
            // let the current player play
            for(int i = 0; i < newPlayers.size(); i++){
            playTurn(newPlayers.get(i));
            if(puzzleSolved){
                break;
            }
        }
        }
    }
    
    /**
     * Sets up all necessary information to run the game
     */
    private void setUpGame() {
        // create a single player 
        boolean phrasesYN = true;
        player1 = new Player("Player1");
        char response;
        Random number= new Random();
        Scanner sc = new Scanner(System.in);
        int numPlayers=0;
        String name;
        //getting the number of players
        //gets the input and if its not a number catch it and ask again
        while(true){
            try{
            System.out.println("Enter how many players: ");
            numPlayers = sc.nextInt();
            break;
            }catch(InputMismatchException ime){
            System.out.println("Error! Please enter a number: ");
            sc.next();
            }
        }
        try{
        //adding the num of players and getting their names
        for (int i = 0; i < numPlayers; i++){
        System.out.println("Enter a player name: ");
        sc.useDelimiter("\n");
        name= sc.next();
        newPlayers.add(new Player(name));
        }
        }catch(Exception e){
            System.out.println("Exception caught setUpGame method: " + e);
        }
        
        // print out the rules
        System.out.println("RULES!");
        System.out.println("Each player gets to spin the wheel, to get a number value");
        System.out.println("Each player then gets to guess a letter. If that letter is in the phrase, ");
        System.out.println(" the player will get the amount from the wheel for each occurence of the letter");
        System.out.println("If you have found a letter, you will also get a chance to guess at the phrase");
        System.out.println("Each player only has three guesses, once you have used up your three guesses, ");
        System.out.println("you can still guess letters, but no longer solve the puzzle.");
        System.out.println();
        System.out.println("Would you like to enter your own phrase(Y/N)?");
        response= sc.next().charAt(0);
        System.out.println();
        //check to see if you want to enter your own phrase if not then pick a random one from list
        try{
        while (phrasesYN){
        if ((response == 'Y') || (response == 'y')){
            System.out.println("Please enter your phrase: ");
            sc.useDelimiter("\n");
            phrase = sc.next();
            phrasesYN = false;
        }
        else if(response == 'n' || response == 'N'){
            otherPhrases();
            int num = number.nextInt(10);
            phrase = setPhrases.get(num);
            phrasesYN = false;
        }
        //If they enter anything other than Y or N then asks for them to answer the question again
        else{
            System.out.println("Did not not enter (Y/N) please choose again!");
            System.out.println("Would you like to enter your own phrase(Y/N)?");
            response= sc.next().charAt(0);  
        }
        }
        //catch the errors that might happen in this method
        }
        catch(Exception e){
            System.out.println("Exception caught setUpGame method: " + e);
        }

        
        // for each character in the phrase, create a letter and add to letters array
        for (int i = 0; i < phrase.length(); i++) {
            //letter_array[i] = new Letter(phrase.charAt(i));
            phrases_letters.add(new Letter(phrase.charAt(i)));
        }
        // setup done
    }
    
    /**
     * One player's turn in the game
     * Spin wheel, pick a letter, choose to solve puzzle if letter found
     * @param player
     * @throws InterruptedException 
     */
    private void playTurn(Player player) throws InterruptedException {
        int money = 0;
        boolean solveYN = true;
        boolean moneyOrPrize = false;
        Scanner sc = new Scanner(System.in);
        try{
        System.out.println(player.getName() + ", you have $" + player.getWinnings());
        System.out.println("Spin the wheel! <press enter>");
        sc.nextLine();
        System.out.println("<SPINNING>");
        Thread.sleep(200);
        Wheel.WedgeType type = wheel.spin();
        System.out.print("The wheel landed on: ");
        switch (type) {
            case MONEY:
                money = wheel.getAmount();
                System.out.println("$" + money);
                moneyOrPrize = false;
                break;
                
            case LOSE_TURN:
                System.out.println("LOSE A TURN");
                System.out.println("So sorry, you lose a turn.");
                return; // doesn't get to guess letter
                
                
            case BANKRUPT:
                System.out.println("BANKRUPT");
                player.bankrupt();
                player.removePrizes();
                return; // doesn't get to guess letter
                
            case PRIZE:
                System.out.println("PRIZE");
                player.potentialPrize();
                moneyOrPrize = true;
                break;
                
            default:
                
        }
        System.out.println("");
        System.out.println("Here is the puzzle:");
        showPuzzle();
        System.out.println();
        System.out.println(player.getName() + ", please guess a letter.");
        //String guess = sc.next();
        
        char letter = sc.next().charAt(0);
        if (!Character.isAlphabetic(letter)) {
            System.out.println("Sorry, but only alphabetic characters are allowed. You lose your turn.");
        } else {
            // search for letter to see if it is in
            int numFound = 0;
            for (Letter l : phrases_letters) {
                if ((l.getLetter() == letter) || (l.getLetter() == Character.toUpperCase(letter))) {
                    l.setFound();
                    numFound += 1;
                }
            }
            if (numFound == 0) {
                System.out.println("Sorry, but there are no " + letter + "'s.");
            } else {
                if (numFound == 1) {
                    System.out.println("Congrats! There is 1 letter " + letter + ":");
                } else {
                    System.out.println("Congrats! There are " + numFound + " letter " + letter + "'s:");
                }
                System.out.println();
                showPuzzle();
                System.out.println();
                if(!moneyOrPrize){
                player.incrementScore(numFound*money);
                System.out.println("You earned $" + (numFound*money) + ", and you now have: $" + player.getWinnings());
                }
                else{
                 player.addPrize();
                }

                System.out.println("Would you like to try to solve the puzzle? (Y/N)");
                letter = sc.next().charAt(0);
                System.out.println();
                while(solveYN){
                if ((letter == 'Y') || (letter == 'y')) {
                    solvePuzzleAttempt(player);
                    solveYN = false;
                }
                else if ((letter == 'N') || (letter == 'n')){
                    break;
                }
                else{
                    System.out.println("Did not not enter (Y/N) please choose again!");
                    System.out.println("Would you like to enter your own phrase(Y/N)?");
                    letter= sc.next().charAt(0);
                    System.out.println("");
                }
                }
            }
            
            
        }//cathc the error that might happen in this method
        }catch(InterruptedException ie){
            System.out.println("Exception caught in the playTurn method: " + ie);
        }catch(Exception e){
            System.out.println("Exception caught in playTurn mmethod: " + e);
        }
        
    }
    
    /**
     * Logic for when user tries to solve the puzzle
     * @param player 
     */
    private void solvePuzzleAttempt(Player player) {
        int winnings =0;
        int numPrizes = 0;
        String win = "temp";
        try{
        if (player.getNumGuesses() >= 3) {
            System.out.println("Sorry, but you have used up all your guesses.");
            return;
        }
        
        player.incrementNumGuesses();
        System.out.println("What is your solution?");
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        String guess = sc.next();
        if (guess.compareToIgnoreCase(phrase) == 0) {
            System.out.println("Congratulations! You guessed it!");
            puzzleSolved = true;
            // Round is over. Write message with final stats
            // TODO
            //checks to see who is the win by money and if money is zero then does it by prizes
            for(int i = 0; i < newPlayers.size(); i++){
            if(winnings< newPlayers.get(i).getWinnings()){
                winnings = newPlayers.get(i).getWinnings();
                win = newPlayers.get(i).getName();
            }
            if(winnings == 0){
                for(int j = 0; j < newPlayers.size(); j++){
                if(numPrizes< newPlayers.get(i).getSize()){
                win = newPlayers.get(i).getName();
            }
                }
            }
            
        }
            //says who wins
            System.out.println(win + " wins!!");
            //prints out each playes winnings and prizes
            for(int i =0; i < newPlayers.size(); i++){
                System.out.println("\n" + newPlayers.get(i).getName()+ " you have won: $" + newPlayers.get(i).getWinnings());
                System.out.print("Prizes won: ");
                if(newPlayers.get(i).getSize() != 0){
                newPlayers.get(i).getPrizes();
                System.out.println();
                }
                else{
                    System.out.println("No prizes");
                }
                
            }
        } else {
            System.out.println("Sorry, but that is not correct.");
        }//catches the errors that might happen in this method
        }catch(Exception e){
            System.out.println("Exception caught in playTurn mmethod: " + e);
        }
    }
    
    /**
     * Display the puzzle on the console
     */
    private void showPuzzle() {
        System.out.print("\t\t");
        for (Letter l : phrases_letters) {
            if (l.isSpace()) {
                System.out.print("   ");
            } else {
                if (l.isFound()) {
                    System.out.print(Character.toUpperCase(l.getLetter()) + " ");
                } else {
                    System.out.print(" _ ");
                }
            }
        }
        System.out.println();
        
    }
    
    /**
     * For a new game reset player's number of guesses to 0
     */
    public void reset() {
        player1.reset();
    }
    
    /**
     *Adds the phrases to the setPhrases array list for possible phrases
     * @return the setPhrases ArrayList
     */
    public ArrayList<String> otherPhrases(){
        //possible other phrases that might be picked if they dont want to choose the phrase
        //add them to the setphrases arraylist
        setPhrases.add("Once upon a time");
        setPhrases.add("Hello world");
        setPhrases.add("This is a test");
        setPhrases.add("Need more phrases");
        setPhrases.add("This is assignment two");
        setPhrases.add("I need more phrases");
        setPhrases.add("Videos");
        setPhrases.add("Computer games");
        setPhrases.add("Xbox system");
        setPhrases.add("Last phrases");
        //return the arraylist
        return setPhrases;
    }
  
}
