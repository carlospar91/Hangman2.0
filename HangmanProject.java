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

        System.out.println("Please choose a topic: 1 for cars, 2 for presidents, 3 for a random topic."
                + "\nIf your input is invalid we will choose a word for you!");
        Scanner sc1 = new Scanner(System.in);
        choice1 = sc1.nextInt();
        //sc1.close(); //@Nicole Deleted scanner close due to error: NoSuchElementException

        
        
        RandomWord randW = new RandomWord(choice1);
        randW.Display();
        String RandomChosenWord = randW.randomChoice();
        System.out.println("Random word is .... " + RandomChosenWord+ " .. This line is for debugging purposes it wont show up once the game is ready to go.\n");
        
        
        System.out.println("Now we are ready to play the game. "
                + "You will have 6 attempts to choose the correct word.  ");

        
        GuessWord guessW = new GuessWord(RandomChosenWord);
        guessW.Guessing();
        //guessW.spaces();
                
    }

}
