/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanproject;

import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author CARLOSPARLOUR
 */
public class RandomWord {
    //this declares all the variables used in the class
    String[] myStringArray = new String[55000];
    //String type;
    int choice;

    public RandomWord(int input) {
        choice = input;
    }

    //This is Method will take in the input of the user and it will find the location of the file and it will play the all of those words in an array
    public void Display() {
        String word = "";

        //int day = 1;
        switch (choice) {
            case 1:
                word = "/Users/CARLOSPARLOUR/NetBeansProjects/HangmanProject/src/hangmanproject/carFile.txt";
                System.out.println("You have choosen Cars, there ae 42 choices GOOD LICK!!");
                break;
            case 2:
                word = "/Users/CARLOSPARLOUR/NetBeansProjects/HangmanProject/src/hangmanproject/presidentFile.txt";
                System.out.println("You have choosen Presidents, there are 45 possible choices GOOD LUCK!!");
                break;
            case 3:
                word = "/Users/CARLOSPARLOUR/NetBeansProjects/HangmanProject/src/hangmanproject/dictionaryHangman.txt";
                System.out.println("There are 46,000 possible choices GOOD LUCK!!");
                break;

            default:
                word = "/Users/CARLOSPARLOUR/NetBeansProjects/HangmanProject/src/hangmanproject/dictionaryHangman.txt";
                System.out.println("Your Pick was invalid so we picked for you! There are 46,000 possible choices GOOD LUCK!!");
                break;
        }

        //used to debug the program so we can make sure the output is correct
        //System.out.println( word + "This is before it statrs to read the file");
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new File(word));
        } catch (FileNotFoundException s) {
            System.out.println("File not Found");
            System.exit(0);
        }

        //while loop used to print out the contents of the file
        int i = 0;
        while (fileIn.hasNextLine()) {

            String line = fileIn.nextLine();
            myStringArray[i] = line;
            //System.out.println(line);
            i++;
        }

        fileIn.close();

    }

    public String randomChoice() {
        String rand_word = myStringArray[(int) (Math.random() * myStringArray.length)];
        while (rand_word == null) {
            rand_word = myStringArray[(int) (Math.random() * myStringArray.length)];
        }

        return rand_word;

    }

}
