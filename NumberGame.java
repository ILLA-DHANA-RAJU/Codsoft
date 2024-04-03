import java.util.Scanner;
import java.util.Random;

public class NumberGame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int round = 1;
        int totalAttempts = 0;
        int totalRoundsWon = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (true) {
            System.out.println("\nRound " + round);
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            
            System.out.println("I've picked a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");
            
            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                totalAttempts++;
                
                if (guess == randomNumber) {
                    hasGuessedCorrectly = true;
                    totalRoundsWon++;
                    System.out.println("Congratulations! You've guessed the number " + randomNumber + " correctly.");
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNumber + ".");
            }
            
            System.out.println("Round " + round + " ended. Rounds won: " + totalRoundsWon + "/" + round + ", Total attempts: " + totalAttempts);
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
            
            round++;
        }
        
        System.out.println("Thank you for playing the Number Guessing Game!");
        scanner.close();
    }
}