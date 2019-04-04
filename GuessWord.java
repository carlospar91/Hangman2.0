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
    int totalAttempt = 0;
    int position = 0;
    int lettersLeft;
    char[] hidden;
    char[] guessedLetters = new char[100];

    public GuessWord(String word) {
        secretWord = word.toLowerCase();
        hidden = new char[secretWord.length()];
        lettersLeft = secretWord.length();
    }

    public void Guessing() {
        //int lettersLeft = secretWord.length();
        Picture hangPic = new Picture();
        
        //hangPic.hangmanImage(secretWord, attempts);
        spaces();
        
        while (attempts != 0 && lettersLeft != 0) {
            
           totalAttempt++;
            getHidden();

            hangPic.hangmanImage(secretWord, attempts);
            
            //System.out.println("\nAttempts left = " + attempts);
            System.out.print("Enter a letter to guess the word: ");
            //User enters character
            Scanner scan2 = new Scanner(System.in);
            String letter = scan2.next();
            letter = letter.toLowerCase();
            char letterOne = letter.charAt(0);
            //alreadyGuessed(letterOne);
            //verifies the the user inputs the correct value, This will not take in multiple values or non caracters, it will take in capital lettes
            while (letterOne < 97 || letterOne > 122 || letter.length() > 1 ) {
                totalAttempt++;
                System.out.print("Your input was incorrect. Please Enter another letter : ");
                letter = scan2.next();
                letter = letter.toLowerCase();
                letterOne = letter.charAt(0);
                //alreadyGuessed(letterOne);
                
                
            }

            boolean exsist = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (letterOne == secretWord.charAt(i)) {
                    hidden[i] = letterOne;
                    exsist = true;
                    lettersLeft--;
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
                    }
                }
            }

            if ((wordGUesseddd == true && lettersLeft == 1) || lettersLeft == 0) {
                lettersLeft = 0;
                System.out.println("THis is the end.");
                hangPic.hangmanImage(secretWord, attempts);
                getHidden();
                break;
            }
        }
        
        hangPic.hangmanImage(secretWord, attempts);
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

//        for (int i = 0; i < secretWord.length(); i++) {
//            System.out.print(hidden[i] + " ");
//        }
    }

    public void getHidden() {
        for (int i = 0; i < secretWord.length(); i++) {
            System.out.print(hidden[i] + " ");
        }
        System.out.println();
    }

    public boolean alreadyGuessed(char c) {
        boolean result = false;
        for (int i = 0; i < 100; i++) {
            
            if (guessedLetters[i] == c) {
                System.out.println("\nThis Letter has already been Guessed!");
                result = true;
                break;
            } else {
                guessedLetters[totalAttempt] = c;
                result = false;
            }

        }
        return result;
    }

}
