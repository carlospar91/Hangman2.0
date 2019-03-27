/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author CARLOSPARLOUR
 */
public class RandomWord {
    String word;
    String[] myStringArray = new String[55000];
    String type;    

    public RandomWord(String name) {
        type = name;
    }

    public String word(){
        return type;
    }
    
    
    public String choice() {
        String choice = type.toLowerCase();
        //System.out.println(choice);
        //This still needs to make all of choice LOWERCASE
        if (choice == "cars") {

            word = "/Users/CARLOSPARLOUR/NetBeansProjects/HangmanProject/src/hangmanproject/carFile.txt";

        } else if (choice == "president") {

            word = "/Users/CARLOSPARLOUR/NetBeansProjects/HangmanProject/src/hangmanproject/presidentFile.txt";

        } else if (choice == "random") {

            word = "/Users/CARLOSPARLOUR/NetBeansProjects/HangmanProject/src/hangmanproject/dictionaryHangman.txt";
        }

        return word;

    }

    //This is Method will verify the 
    public void Display(String Name) {

        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new File(Name));
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

    }

    public String randomChoice() {
        String rand_word = myStringArray[(int) (Math.random() * myStringArray.length)];
        while (rand_word == null) {
            rand_word = myStringArray[(int) (Math.random() * myStringArray.length)];
        }

        return rand_word;

    }

}
