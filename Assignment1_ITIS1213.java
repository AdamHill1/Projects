/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HillAdam_Assignment1_ITIS1213;

import BookClasses.*;
import java.io.*;
import java.nio.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 * This is the test harness for Assignment 1, and it is used to call and test
 * the audio poetry methods.
 *
 * @author clatulip, (add your name here)
 */
public class Assignment1_ITIS1213 {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        
        //TODO: change the path below to reflect the path to your mediasources file
        String path = "G:\\NetBeans\\mediasources\\";

        //*********************************************************************
        // DO NOT CHANGE THE CODE BELOW
        int spliceIndex[] = new int[200];
        int numSplicePoints = 0;
        String soundFilename;
        String spliceFilename;

        // next two lines create a custom file chooser, with a specific frame heading
        JFileChooser myChooser = new JFileChooser(path);
        myChooser.setDialogTitle("Please select a sound file...");
        // now set media path to point to media sources
        FileChooser.setMediaPath(path);
        // open file chooser and get name of sound file
        soundFilename = FileChooser.pickPath(myChooser);
        // create a sound object from this filename
        Sound mySound = new Sound(soundFilename);

        // try to open the second file, which contains the list of splice points
        myChooser.setDialogTitle("Now select the file that contains the splice points...");
        spliceFilename = FileChooser.pickPath(myChooser);
        // open the file
        File file = new File(spliceFilename);
        // create a scanner object variable so we can read in the file, token by token
        Scanner s = null;
        // some of the code below could generate exceptions, so enclose in try-catch
        try {
            s = new Scanner(new BufferedReader(new FileReader(file)));
            // check if there is another token in the file
            while (s.hasNext()) {
                // check if it's a number
                if (s.hasNextInt()) {
                    // add it to the array, increment number of items in array
                    spliceIndex[numSplicePoints] = s.nextInt();
                    numSplicePoints++;
                } else {
                    // if it's not a number, skip it
                    s.next();
                }
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("main method: splicefile not found");
        } catch (InputMismatchException ime) {
            System.out.println("main method: splice input not integer");
        } catch (NoSuchElementException nsee) {
            System.out.println("main method: no such element after " + numSplicePoints);
        } finally {
            // this gets called no matter what, to close the scanner
            if (s != null) {
                s.close();
            }
        }

        // create an audiopoem object out of the sound and the splicearary
        AudioPoem myPoem = new AudioPoem(mySound, spliceIndex, numSplicePoints);

        // DO NOT CHANGE THE CODE ABOVE
        //**********************************************************
        //**********************************************************
        // TODO: Put your Assignment 1 code to play the different AudioPoem methods here
        String filename1 = "test1.wav";
        String filename2 = "test2.wav";
        String filename3 = "test3.wav";
        String filename4 = "test4.wav";
        String filename5 = "test5.wav";
        String filename6 = "test6.wav";
        //part1 call the methods to test if they work
        
        myPoem.play();
        Thread.sleep(1000);
        myPoem.play(100);
        Thread.sleep(1000);
        myPoem.playRandomOrder(10, 200);
        Thread.sleep(1000);
        myPoem.playRandomUnique(200);
        Thread.sleep(1000);
        myPoem.playReverseOrder(200);
        Thread.sleep(1000);
        myPoem.playDoublets(5);
        Thread.sleep(1000);
        
        
        
        //part2 call the methods to test if they work
        myPoem.play(200, filename1, path);
        Thread.sleep(1000);
        myPoem.playRandomOrder(4, 200, filename2, path);
        Thread.sleep(1000);
        myPoem.playRandomUnique(200, filename3, path);
        Thread.sleep(1000);
        myPoem.playReverseOrder(200, filename4, path);
        Thread.sleep(1000);
        myPoem.playDoublets(5, filename5, path);
        Thread.sleep(1000);
        
        //part3 call the methods to test if they work
        myPoem.playDoubletsReverse(5);
        Thread.sleep(1000);
        myPoem.playDoubletsReverse(5, filename6, path);

    }
}
