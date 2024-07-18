import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;
    private static final int RANGE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            int numberToGuess = random.nextInt(RANGE) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nRound " + round + " of " + MAX_ROUNDS);
            System.out.println("Guess a number between 1 and " + RANGE);

            while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    int points = MAX_ATTEMPTS - attempts + 1;
                    totalScore += points;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("You earned " + points + " points.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("The number is higher than your guess.");
                } else {
                    System.out.println("The number is lower than your guess.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry! You've used all " + MAX_ATTEMPTS + " attempts. The number was " + numberToGuess + ".");
            }
        }

        System.out.println("\nGame Over! Your total score is: " + totalScore);
        scanner.close();
    }
}
