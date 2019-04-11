package hangmanproject;

public class Picture {

    String secretWord;
    int attempts;

    public Picture() {
    
    }

    public void hangmanImage(String word, int remainingGuesses) {
        attempts = remainingGuesses;

        switch (attempts) {
            case 6:
                //System.out.println(attempts);
                System.out.println();
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("___|___");
                System.out.println();
                break;
            case 5:
                System.out.println("Wrong guess, try again, 5 gusses left");
                System.out.println("   ____________");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   | ");
                System.out.println("___|___");
                break;
            case 4:
                System.out.println("Wrong guess, try again, 4 guesses left");
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        |     |");
                System.out.println("   |         \\_ _/");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("___|___");
                break;
            case 3:
                System.out.println("Wrong guess, try again, 3 guesses left");
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        | O O |");
                System.out.println("   |         \\_^_/");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("___|___");
                break;
            case 2:
                System.out.println("Wrong guess, try again, 2 guesses left");
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        | O O |");
                System.out.println("   |         \\_^_/");
                System.out.println("   |           |");
                System.out.println("   |           |");
                System.out.println("   |");
                System.out.println("___|___");
                break;
            case 1:
                System.out.println("Wrong guess, try again, 1 guesses left");
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        | O O |");
                System.out.println("   |         \\_^_/");
                System.out.println("   |           |");
                System.out.println("   |           |");
                System.out.println("   |          / \\ ");
                System.out.println("___|___      /   \\");
                break;
            case 0:
                System.out.println("GAME OVER");
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        | O O |");
                System.out.println("   |         \\_^_/");
                System.out.println("   |          _|_");
                System.out.println("   |         / | \\");
                System.out.println("   |          / \\ ");
                System.out.println("___|___      /   \\");
                System.out.println("THE WORD YOU COULD NOT GUESS IS.... " + word);
                break;
            default:
                break;
        }

    }

}
