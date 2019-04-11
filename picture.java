package hangmanproject;

public class Picture {

    String secretWord;
    int attempts;

    public Picture() {

    }

    //This methhod will take in the secret word and the number of remaining guesses and display the correct picture
    public void hangmanImage(String word, int remainingGuesses) {
        attempts = remainingGuesses;

        switch (attempts) {
            case 6:
                //This is the start of the game. 
                System.out.println();
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("___|___\n");
                System.out.println();
                break;
            case 5:
                //one incorrect guess
                System.out.println();
                System.out.println("5 guesses left");
                System.out.println("   ____________");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   | ");
                System.out.println("___|___\n");
                break;
            case 4:
                //two incorrect guess
                System.out.println();
                System.out.println("4 guesses left");
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        |     |");
                System.out.println("   |         \\_ _/");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("___|___\n");
                break;
            case 3:
                //3 incorrect guess
                System.out.println();
                System.out.println("3 guesses left");
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        | O O |");
                System.out.println("   |         \\_^_/");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("___|___\n");
                break;
            case 2:
                //four incorrect guess
                System.out.println();
                System.out.println("2 guesses left");
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        | O O |");
                System.out.println("   |         \\_^_/");
                System.out.println("   |           |");
                System.out.println("   |           |");
                System.out.println("   |");
                System.out.println("___|___\n");
                break;
            case 1:
                //five incorrect guess
                System.out.println();
                System.out.println("1 guesses left");
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        | O O |");
                System.out.println("   |         \\_^_/");
                System.out.println("   |           |");
                System.out.println("   |           |");
                System.out.println("   |          / \\ ");
                System.out.println("___|___      /   \\\n");
                break;
            case 0:
                //six incorrect guess and the game is now over. This will display the correct word at the end 
                //System.out.println("");
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        | O O |");
                System.out.println("   |         \\_^_/");
                System.out.println("   |          _|_");
                System.out.println("   |         / | \\");
                System.out.println("   |          / \\ ");
                System.out.println("___|___      /   \\\n");
                System.out.println("GAME OVER! " + "THE WORD YOU COULD NOT GUESS IS.... " + word + "\n");
                break;
            default:
                break;
        }

    }

}
