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

/*
 * @ 04.2.19 NicoleBritt
 */
public class GuessWord {

    String secretWord;
    int attempts = 6;
    int totalAttempt = 0;
    int position = 0;
    int lettersLeft;
    char[] hidden;
    List<Character> alphabet = new ArrayList<>();
    char letterOne;
    Picture hangPic;

    //04.2.19 NicoleBritt: Constructor that will initialize important variables used in this class
    public GuessWord(String word) {
        secretWord = word.toLowerCase();
        hidden = new char[secretWord.length()];
        lettersLeft = secretWord.length();
    }

    //04.10.19 NicoleBritt: This method is used to get the letters and check to see if they have been guessed. 
    public void Guessing() {
        hangPic = new Picture();
        spaces();
        createAlphabet();
        printListChar();

        //04.10.19 NicoleBritt: While loop used to keep the guess going
        while (attempts != 0 && lettersLeft != 0) {
            boolean alreadyexisit = false;
            totalAttempt++;
            getHidden();

            //04.10.19 NicoleBritt: Displays the picture and then the current the remaining letters you can guess
            hangPic.hangmanImage(secretWord, attempts);
            printListChar();

            System.out.print("Enter a letter to guess the word: ");
            Scanner scan2 = new Scanner(System.in);
            String letter = scan2.next();

            //04.10.19 NicoleBritt: This will not allow the user to input something larger than length 1
            while (letter.length() > 1) {
                System.out.print("Try again, invalid input: ");
                //User enters character
                scan2 = new Scanner(System.in);
                letter = scan2.next();
            }

            letter = letter.toLowerCase();
            letterOne = letter.charAt(0);
            alreadyexisit = listChar(letterOne);

            //04.10.19 NicoleBritt: verifies the the user inputs the correct value, This will not take in multiple values or non caracters, it will take in capital lettes
            while (letterOne < 97 || letterOne > 122 || letter.length() > 1 || alreadyexisit == false) {
                totalAttempt++;
                System.out.print("Your input was incorrect. Please Enter another letter : ");
                letter = scan2.next();
                letter = letter.toLowerCase();
                letterOne = letter.charAt(0);
                alreadyexisit = listChar(letterOne);

            }

            verifyFinished();

        }
        //04.10.19 NicoleBritt: Used to print the final image 04.11.19 Luis Moreno
        if (attempts == 0) {
            hangPic.hangmanImage(secretWord, attempts);
        }//printListChar();
        //System.out.println("This is the total number of attempts taken>>> : >>" + totalAttempt);

    }

    //04.10.19 NicoleBritt: This method will only be called ONCE and is used to hide the secretword.
    //04.10.19 NicoleBritt: It will turn chars/letters into '*' and spaces into '_'.
    public void spaces() {
        for (int i = 0; i < secretWord.length(); i++) {
            hidden[i] = '*';
        }

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == 32) {
                hidden[i] = '_';
            }
        }
    }

    //04.10.19 NicoleBritt: This is used to print out the char array this is the secret word.
    public void getHidden() {
        for (int i = 0; i < secretWord.length(); i++) {
            System.out.print(hidden[i] + " ");
        }
        System.out.println();
    }

    //04.10.19 NicoleBritt: This is used to check if the letter has been guessed.
    public boolean listChar(char ch) {
        boolean ans = alphabet.contains(ch);
        //System.out.print(ans);

        int index = (ch - 97);
        //04.10.19 NicoleBritt: If the letter exist in alphabet then the letter has not been guessed
        if (ans) {
            System.out.println();

            // 04.11.19 Luis Moreno: Since the letter has not been guess, we will replace it with # to signify it has been guessed.
            alphabet.set(index, '#');
            ans = true;
        } else {

            //04.10.19 NicoleBritt: If the letter does not exist then it has already been guessed
            //04.11.19 Luis Moreno: System.out.print(ch + "  has already been used!!!"); 
            ans = false;
            //System.out.println("This guess already exisist!!");

        }
        return ans;
    }

    //04.10.19 NicoleBritt: this will print a CURRENT UPDATED list of all the letters that haven't bee guessed.  
    public void printListChar() {

        System.out.println("These are the letters you have remaining to choose from:");
        System.out.println("\n" + alphabet + "\n");

    }

    //04.11.19 Luis Moreno: This creates the Arraylist of char's for the alphabet and will be called in the constructor. 
    public void createAlphabet() {
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');
        alphabet.add('d');
        alphabet.add('e');
        alphabet.add('f');
        alphabet.add('g');
        alphabet.add('h');
        alphabet.add('i');
        alphabet.add('j');
        alphabet.add('k');
        alphabet.add('l');
        alphabet.add('m');
        alphabet.add('n');
        alphabet.add('o');
        alphabet.add('p');
        alphabet.add('q');
        alphabet.add('r');
        alphabet.add('s');
        alphabet.add('t');
        alphabet.add('u');
        alphabet.add('v');
        alphabet.add('w');
        alphabet.add('x');
        alphabet.add('y');
        alphabet.add('z');
    }

    // 04.10.19 NicoleBritt: This is used to make sure the inputs is only 1 char. 
    public char stringLen(String input) {
        char result = input.charAt(0);
        //String letter;
        if (input.length() > 1) {
            System.out.print("Enter ONlY 1 letter!!!  ");
            Scanner scan2 = new Scanner(System.in);
            input = scan2.next();
            input = input.toLowerCase();
            stringLen(input);
            //stringLen(letter);
        } else if (input.length() == 1) {
            result = input.charAt(0);
        }

        System.out.println(result);
        return result;

    }

    // 04.10.19 NicoleBritt: This method is used to check if all of the letters are guessed in the word.
    public void verifyFinished() {

        // 04.10.19 NicoleBritt: This loop will go through the secret word and check to see if the guessed letter exists in the secret word
        boolean exsist = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (letterOne == secretWord.charAt(i)) {
                hidden[i] = letterOne;
                exsist = true;
                lettersLeft--;
            }
        }

        //if the letter does not exist this will update the number of guesses remaining. 04.11.19 Luis Moreno
        if (exsist == false) {
            System.out.println("Wrong guess, here is your penalty");
            attempts--;
        }

        //04.11.19 Luis Moreno: This will check to see if there is any more '*'. if there isn't then it means the word has been guessed.
        //04.11.19 Luis Moreno: This is here because some words have spaces and it will ignore the spaces. 

 
        boolean wordGUesseddd = true;
        if (lettersLeft == 1 || lettersLeft == 2) {
            for (int i = 0; i < secretWord.length(); i++) {
                if (hidden[i] == '*') {
                    wordGUesseddd = false;
                }
            }
        }

        //  04.10.19 Carlos Parlour: This takes all of the conditions from above and if all of them are true then the word has been correctly guessed.
        if ((wordGUesseddd == true && (lettersLeft == 1)) || (wordGUesseddd == true && lettersLeft == 2) || lettersLeft == 0) {
            lettersLeft = 0;
            System.out.println("Great job you guessed the right word! The secret word is " + secretWord);
            //hangPic.hangmanImage(secretWord, attempts);
            //getHidden();
            //break;
        }

    }

}
