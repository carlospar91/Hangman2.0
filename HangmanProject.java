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
        int choice1;

        System.out.print("Please choose a topic: 1 for cars, 2 for presidents, 3 for a random topic."
                + "\nIf your input is invalid we will choose a word for you!  ");
        Scanner sc1 = new Scanner(System.in);
        choice1 = sc1.nextInt();
        //sc1.close(); //@Nicole Deleted scanner close due to error: NoSuchElementException

        RandomWord randW = new RandomWord(choice1);
        randW.Display();
        String RandomChosenWord = randW.randomChoice();
        System.out.println("\nRandom word is .... " + RandomChosenWord + " .. This line is for debugging purposes it wont show up once the game is ready to go.\n");

        System.out.println("Now we are ready to play the game. "
                + "You will have 6 attempts to choose the correct word.  " + "\n");

        GuessWord guessW = new GuessWord(RandomChosenWord);
        guessW.Guessing();

        System.out.print("Would you like to play again? Enter Y or N ");
        String playAgain = sc1.next();

        playAgain = playAgain.toUpperCase();
        char cPlay = playAgain.charAt(0);

        if (cPlay == 'Y') {

            System.out.print("Please choose a topic: 1 for cars, 2 for presidents, 3 for a random topic."
                    + "\nIf your input is invalid we will choose a word for you!  ");
            //Scanner sc1 = new Scanner(System.in);
            choice1 = sc1.nextInt();
            randW = new RandomWord(choice1);
            randW.Display();
            RandomChosenWord = randW.randomChoice();
            System.out.println("\nRandom word is .... " + RandomChosenWord + " .. This line is for debugging purposes it wont show up once the game is ready to go.\n");

            System.out.println("Now we are ready to play the game. "
                    + "You will have 6 attempts to choose the correct word.  " + "\n");

            guessW = new GuessWord(RandomChosenWord);
            guessW.Guessing();

            System.out.print("Would you like to play again? Enter Y or N ");
            playAgain = sc1.next();

            playAgain = playAgain.toUpperCase();
            cPlay = playAgain.charAt(0);

        } 

            System.out.println("Thank you for playing. This program has been closed gracefully.");
        
    }

}
