package hangmanproject;

import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author CARLOSPARLOUR, LUIS MORENO, NICOLE BRITT
 */

//04.11.19 - Carlos Parlour
public class HangmanProject {

   
    public static void main(String[] args) {
        letsPlay();
    }

    //04.11.19 - Carlos Parlour: This is the main portion of the game play this is where we verify the input of the user. 
    public static void letsPlay() {

        Scanner sc1 = new Scanner(System.in);
        //initial value is set to Y so we can start the program. The while loop is used to see if the 
        //player still wants to play
        char cPlay = 'Y';

        //while loop used to make sure the value 
        while (cPlay == 'Y') {
            int choice1 = 3;
            System.out.print("Please choose a topic: 1 for cars, 2 for presidents, 3 for a random topic.");

            try {
                System.out.print(" Please input an integer: ");
                //nextInt will throw InputMismatchException
                choice1 = sc1.nextInt();
            } catch (InputMismatchException exception) {
                //when the player inputs an inccorect input
                System.out.println("Your input was not an Integer so we picked a word for you!");
            }

            mainGamePlay(choice1);
            cPlay = playAgain();
        }
        System.out.println("Thank you for playing. This program has been closed gracefully.");
    }

    //04.10.19 - Carlos Parlour: This is the initial part of the program this it where we get the random word the player will need to guess. 
    public static void mainGamePlay(int input) {
        int choice1 = input;
        RandomWord randW;
        randW = new RandomWord(choice1);
        randW.Display();
        String RandomChosenWord = randW.randomChoice();
        // 04.10.19 Luis Moreno: String RandomChosenWord = "testing";
        // 04.10.19 Luis Moreno: System.out.println("\nRandom word is .... " + RandomChosenWord + " .. This line is for debugging purposes it wont show up once the game is ready to go.\n");

        System.out.println("You will have 6 attempts to choose the correct word.  " + "\n");

        GuessWord guessW = new GuessWord(RandomChosenWord);
        guessW.Guessing();

    }

    //04.10.19 - Carlos Parlour: this function will let tell verify if we play again. it will check the input to make sure that the 
    //04.10.19 - Carlos Parlour: is the correct answer. 
    public static char playAgain() {
        Scanner sc1 = new Scanner(System.in);
        //char cPlay = c;
        System.out.print("Would you like to play again? Enter Y or N. ");

        String playAgain = sc1.next();
        playAgain = playAgain.toUpperCase();
        char cPlay = playAgain.charAt(0);

        //04.10.19 Luis Moreno: This is the part of the function will verify the input of the and if it is correct it will break the loop and exist. 
        while (cPlay != 89 || cPlay != 78) {
            if (cPlay == 89 || cPlay == 78) {
                cPlay = playAgain.charAt(0);
                break;
            }
            System.out.println("That was not a valid input. Please try again");
            playAgain = sc1.next();
            playAgain = playAgain.toUpperCase();
            cPlay = playAgain.charAt(0);
            //System.out.println(cPlay);
        }
        return cPlay;
    }

}
