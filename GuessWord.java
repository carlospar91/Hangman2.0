package hangmanproject;

import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * @author NicoleBritt
 */
public class GuessWord {

    String secretWord;
    int attempts = 6;
    int position = 0;
    int lettersLeft;
    char[] hidden;
    char[] guessedLetters = new char[26];

    public GuessWord(String word) {
        secretWord = word.toLowerCase();
        hidden = new char[secretWord.length()];
        lettersLeft = secretWord.length();
    }

    
    public void Guessing() {
        int lettersLeft = secretWord.length();
//      char[] hidden = new char[secretWord.length()];
        spaces();
        System.out.println(attempts);

        //boolean wordGUesseddd = false;

        while (attempts != 0 && lettersLeft != 0) {
            for (int i = 0; i < secretWord.length(); i++) {
                System.out.print(hidden[i] + " ");
            }

            System.out.println("\nAttempts left = " + attempts);
            System.out.println("Enter a letter to guess the word: ");
            //User enters character
            Scanner scan2 = new Scanner(System.in);
            String letter = scan2.next();
            letter = letter.toLowerCase();
            char letterOne = letter.charAt(0);

            boolean exsist = false;

            for (int i = 0; i < secretWord.length(); i++) {
                //System.out.println(", THis is the user Guess -> " + letterOne + ", THis is the current selection -> " + secretWord.charAt(i));

                if (letterOne == secretWord.charAt(i)) {
                    hidden[i] = letterOne;
                    exsist = true;
                    lettersLeft--;
                    //break;
                }

            }

            if (exsist == false) {
                attempts--;

            }
            
            boolean wordGUesseddd = true;
            if (lettersLeft == 1) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (hidden[i] == '*') {
                        wordGUesseddd = false;
                        //System.out.println("THis is the end.");
                        //break;
                    }

                }
            }
            
            
            if ((wordGUesseddd == true && lettersLeft == 1) || lettersLeft == 0 ) {
                lettersLeft = 0;
                System.out.println("THis is the end.");
                getHidden();
                break;
            }
            
            
            
            
        }
    }

    //This method provides us with the array that will be used to display the words
    public void spaces() {
        for (int i = 0; i < secretWord.length(); i++) {
            hidden[i] = '*';
        }

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == 32) {
                //System.out.print(hidden[i]);
                hidden[i] = '_';
                //System.out.print(hidden[i] + " ");
            }
        }

        for (int i = 0; i < secretWord.length(); i++) {
            System.out.print(hidden[i] + " ");
        }
    }
    
    
    public void getHidden(){
        for (int i = 0; i < secretWord.length(); i++) {
            System.out.print(hidden[i]);
        }
    }

}
