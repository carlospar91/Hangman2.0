/**
 *
 * @author CARLOSPARLOUR, LUIS MORENO, NICOLE BRITT
 */

package hangmanproject;

import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author CARLOSPARLOUR 04.5.19 - Carlos Parlour
 */ 

public class RandomWord {

    //this declares all the variables used in the class
    String[] myStringArray;
    int choice;
    String word;

    public RandomWord(int input) {
        choice = input;
        myStringArray = new String[55000];
    }

    //04.5.19 - Carlos Parlour: This is Method will take in the input of the user and it will find the location of the file 
    //04.5.19 - Carlos Parlour: It will set word to the location of the file so the program can open the correct one. 
    public void Display() {

        switch (choice) {
            case 1:
                word = "carFile.txt";
                System.out.println("\nYou have choosen Cars, there are 42 choices GOOD LUCK!!");
                break;
            case 2:
                word = "presidentFile.txt";
                System.out.println("\nYou have choosen Presidents, there are 45 possible choices GOOD LUCK!!");
                break;
            case 3:
                word = "dictionaryHangman.txt";
                System.out.println("\nThere are 45,349 possible choices GOOD LUCK!!");
                break;

            default:
                word = "dictionaryHangman.txt";
                System.out.println("\nYour Pick was invalid so we picked for you! There are 45,349 possible choices GOOD LUCK!!");
                break;
        }

        //used to debug the program so we can make sure the output is correct
        //System.out.println( word + "This is before it statrs to read the file");
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new File(word));
        } catch (FileNotFoundException s) {
            System.out.println("File not Found");
            //System.exit(0);
        }

        //while loop used to print out the contents of the file
        int i = 0;
        while (fileIn.hasNextLine()) {

            String line = fileIn.nextLine();
            myStringArray[i] = line;
            //System.out.println(line);
            i++;
        }
    }

    //04.5.19 - Carlos Parlour: This is the function that will randomly choose a word. 
    public String randomChoice() {
        String rand_word = myStringArray[(int) (Math.random() * myStringArray.length)];
        while (rand_word == null) {
            rand_word = myStringArray[(int) (Math.random() * myStringArray.length)];
        }
        return rand_word;
    }

}
