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
public class HangmanProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String choice1 = "";
        
        System.out.println("Please choose a topic: Presidents, Cars or Random");
        Scanner sc1 = new Scanner(System.in);
        
//        choice1 = sc1.next();
//        choice1 = choice1.toLowerCase();
//        System.out.println(choice1);
        choice1 = "president";
        
        RandomWord randW = new RandomWord(choice1);
        System.out.println(randW.word());
        String word = randW.choice();
        randW.Display(word);
        String RandomChosenWord = randW.randomChoice();
        System.out.println(RandomChosenWord);
        
        //
//        String[] myStringArray = new String[55000];
//        String rand_word;
//        
//        System.out.println("CHoose a topic");
//        //This simulated a player choosing a file 
//        String choice = "Random";
//        String choosen = location(choice);
//        System.out.println(choosen);
//        
//        
//        //this is the part of the prgram that will verify the file exisit
//        Scanner fileIn = null;
//        try {
//            fileIn = new Scanner(new File(choosen));
//        } catch (FileNotFoundException s) {
//            System.out.println("File not Found");
//            System.exit(0);
//        }
//
//        int i = 0;
//        while (fileIn.hasNextLine()) {
//            
//            String line = fileIn.nextLine();
//            myStringArray[i] = line;
//            //System.out.println(line);
//            i++;
//        }
//        
//        //This part of the program will produce the random word
//        rand_word = myStringArray[ (int)(Math.random() * myStringArray.length) ];
//        while (rand_word == null){
//             rand_word = myStringArray[ (int)(Math.random() * myStringArray.length) ];
//        }
//       
        System.out.print("Random word is .... ");
        
        
//        System.out.println(rand_word);
    
    }
    
    
    //this is the funciton used to print out the correct location of the 
//    public static String location(String choice){
//        String word = "";
//        //This still needs to make all of choice LOWERCASE
//        if (choice == "cars"){
//            
//            word = "/Users/CARLOSPARLOUR/NetBeansProjects/HangmanProject/src/hangmanproject/carFile.txt";
//        
//        } else if (choice == "president"){
//        
//            word = "/Users/CARLOSPARLOUR/NetBeansProjects/HangmanProject/src/hangmanproject/presidentFile.txt";
//            
//        } else if (choice == "Random"){
//            
//            word = "/Users/CARLOSPARLOUR/NetBeansProjects/HangmanProject/src/hangmanproject/dictionaryHangman.txt";
//        }
//       
//    
//    return word;
//    }

}
