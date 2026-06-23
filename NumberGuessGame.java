import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int totalWins = 0;
        boolean playAgain = true;

        System.out.println("==================================");
        System.out.println("     WELCOME TO GUESS MASTER");
        System.out.println("==================================");

        while (playAgain) {

            int secretNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have only " + maxAttempts + " attempts.");

            while (attemptsLeft > 0) {

                System.out.print("\nEnter your guess: ");
                int userGuess = input.nextInt();

                attemptsLeft--;

                if (userGuess == secretNumber) {
                    guessedCorrectly = true;
                    totalWins++;

                    System.out.println("Correct! You guessed the number.");
                    System.out.println("Attempts used: " + (maxAttempts - attemptsLeft));
                    break;
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }

                System.out.println("Attempts remaining: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.println("\nTotal Wins: " + totalWins);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = input.next();

            playAgain = choice.equalsIgnoreCase("yes");
        }

        System.out.println("\nThanks for playing!");
        input.close();
    }
}