package rps.thegame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserDialogs {
    public static int getNumberOfRounds() throws InputMismatchException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number of rounds: ");
            try {
                int rounds = scanner.nextInt();
                if (rounds < 1 || rounds > 10) {
                    System.out.println("Enter number between 1 and 10.");
                } else {
                    return rounds;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again.");
            }
        }
    }

    public static UserSelection getUserSelection() {
        System.out.println("Make a choice...");
        System.out.println("1 = ROCK\n2 = PAPER\n3 = SCISSORS\nN = NEW GAME\nQ = QUIT GAME");
        try {
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "1":
                    return UserSelection.ROCK;
                case "2":
                    return UserSelection.PAPER;
                case "3":
                    return UserSelection.SCISSORS;
                case "Q":
                    return UserSelection.QUIT;
                case "N":
                    return UserSelection.NEW_GAME;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong choice");
        }
        return null;
    }

    public static void showStats(int humanScore, int computerScore, UserSelection userSelection, UserSelection computerSelection, int round, int rounds, Winner winner) {
        System.out.println("Round " + round + " / " + rounds);
        System.out.print("You selected [" + userSelection + "], computer selected [" + computerSelection + "]");
        if (winner == Winner.HUMAN)
            System.out.println(" --> You Win!");
        else if (winner == Winner.COMPUTER)
            System.out.println(" --> Computer Wins!");
        else
            System.out.println(" --> It's a TIE!");
        System.out.println("Your score [" + humanScore + "], computer score [" + computerScore + "]");
    }

    public static void showFinalStats(int computerScore, int humanScore) {
        if (computerScore > humanScore)
            System.out.println("Computer wins: [" + computerScore + "] to [" + humanScore + "]");
        else if (humanScore > computerScore)
            System.out.println("You win: [" + humanScore + "] to [" + computerScore + "]");
        else
            System.out.println("Summary: human [" + humanScore + "], computer [" + computerScore + "]");
    }
}