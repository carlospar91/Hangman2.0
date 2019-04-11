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
    List<Character> alphabet = new ArrayList<>();
    char letterOne;
    Picture hangPic;

    //constructor thtat will inizilize important variables used in this class
    public GuessWord(String word) {
        secretWord = word.toLowerCase();
        hidden = new char[secretWord.length()];
        lettersLeft = secretWord.length();
    }

    public void Guessing() {
        hangPic = new Picture();
        spaces();
        createAlphabet();
        printListChar();

        while (attempts != 0 && lettersLeft != 0) {
            boolean alreadyexisit = false;
            totalAttempt++;
            getHidden();

            hangPic.hangmanImage(secretWord, attempts);
            printListChar();

            System.out.print("Enter a letter to guess the word: ");
            //User enters character
            Scanner scan2 = new Scanner(System.in);
            String letter = scan2.next();

            while (letter.length() > 1) {
                System.out.print(" Try again, invalid input: ");
                //User enters character
                scan2 = new Scanner(System.in);
                letter = scan2.next();
            }

            letter = letter.toLowerCase();
            letterOne = letter.charAt(0);
            alreadyexisit = listChar(letterOne);

            //verifies the the user inputs the correct value, This will not take in multiple values or non caracters, it will take in capital lettes
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
        System.out.println();
        hangPic.hangmanImage(secretWord, attempts);
        //printListChar();
        //System.out.println("This is the total number of attempts taken>>> : >>" + totalAttempt);

    }

    //This method provides us with the array that will be used to display the words
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

    public void getHidden() {
        for (int i = 0; i < secretWord.length(); i++) {
            System.out.print(hidden[i] + " ");
        }
        System.out.println();
    }

    public boolean listChar(char ch) {
        boolean ans = alphabet.contains(ch);
        //System.out.print(ans);

        int index = (ch - 97);
        if (ans) {
            System.out.println();
            alphabet.set(index, '#');
            ans = true;
        } else {
            //System.out.print(ch + "  has already been used!!!");
            ans = false;
            //System.out.println("This guess already exisist!!");

        }
        return ans;
    }

    public void printListChar() {

        System.out.println("These are the letters you have remaining to choose from:");
        System.out.println("\n"+alphabet+"\n");

    }

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

    public void verifyFinished() {

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
        if (lettersLeft == 1 || lettersLeft == 2) {
            for (int i = 0; i < secretWord.length(); i++) {
                if (hidden[i] == '*') {
                    wordGUesseddd = false;
                }
            }
        }

        if ((wordGUesseddd == true && (lettersLeft == 1)) || (wordGUesseddd == true && lettersLeft == 2) || lettersLeft == 0) {
            lettersLeft = 0;
            System.out.println("Great job you guessed the right word!");
            //hangPic.hangmanImage(secretWord, attempts);
            getHidden();
            //break;
        }

    }

}
