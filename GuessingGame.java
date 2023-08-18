 import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        final int MAX_NUMBER = 100;
        final int MAX_ATTEMPTS = 10;
        final String YES = "yes";
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int score = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            int randomNumber = random.nextInt(MAX_NUMBER) + 1;
            int attempts = MAX_ATTEMPTS;
            boolean roundWon = false;
            
            System.out.println("Welcome to the Guessing Game!");
            System.out.println("I've chosen a number between 1 and " + MAX_NUMBER + ". Can you guess it?");
            
            for (int i = 1; i <= attempts; i++) {
                System.out.print("Attempt " + i + "/" + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                    roundWon = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }
            
            if (!roundWon) {
                System.out.println("Round over. The correct number was: " + randomNumber);
            } else {
                score++;
            }
            
            System.out.println("Your current score: " + score);
            
            System.out.print("Do you want to play again? (" + YES + "/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals(YES);
        }
        
        System.out.println("Thanks for playing! Your final score: " + score);
        scanner.close();
    }
}
