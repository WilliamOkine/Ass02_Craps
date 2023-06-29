import java.util.Random;
import java.util.Scanner;

public class Craps {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to Craps!");

            int firstRoll = rollDice(rand);
            System.out.println("First roll: " + firstRoll);

            if (firstRoll == 2 || firstRoll == 3 || firstRoll == 12) {
                System.out.println("Craps! You lose.");
            } else if (firstRoll == 7 || firstRoll == 11) {
                System.out.println("Natural! You win.");
            } else {
                System.out.println("Point is set to " + firstRoll);
                boolean keepRolling = true;

                while (keepRolling) {
                    int nextRoll = rollDice(rand);
                    System.out.println("Next roll: " + nextRoll);

                    if (nextRoll == 7) {
                        System.out.println("You rolled a 7. You lose.");
                        keepRolling = false;
                    } else if (nextRoll == firstRoll) {
                        System.out.println("You made the point! You win.");
                        keepRolling = false;
                    }
                }
            }

            System.out.print("Play again? (yes/no): ");
            String choice = scan.nextLine();
            playAgain = choice.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing Craps!");
    }

    public static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        return die1 + die2;
    }
}
