package rps.thegame;

import java.util.InputMismatchException;
import java.util.Scanner;

import static rps.thegame.RpsRunner.play;

public class UserDialogs {

    private String name;
    private int rounds;

    public static void displayInfo(String name, int rounds) {
        System.out.println("Hi " + name + ", you will play " + rounds + " rounds.");
    }

    public static Select userMove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - ROCK\n2 - PAPER\n3 - SCISSORS\n\nX - Exit game\nN - New game");
            String input = scanner.nextLine().toUpperCase();
            switch (input) {
                case "1":
                    return Select.ROCK;
                case "2":
                    return Select.PAPER;
                case "3":
                    return Select.SCISSORS;
                case "x":
                    return Select.EXIT;
                case "N":
                    return Select.NEW_GAME;
                default:
                    System.out.println("Wrong input, try again.");
            }
        }
    }

    public static void roundSummary(String name, int userWins, int pcWins, int rounds) {
        System.out.println("Round number " + rounds + "Your wins: " + userWins + ", pc wins: " + pcWins);
    }

    public static void endGame(int userWins, int pcWins) {
        if (userWins > pcWins)
            System.out.println("You win: You [" + userWins + "] : [" + pcWins + "] pc.");
        else if (pcWins > userWins)
            System.out.println("You lose: pc [" + pcWins + "] : [" + userWins + "] You.");
        else
            System.out.println("It's a tie.");
    }

    public static void newGame() {
        System.out.println("Do you want to start a new game ? Y/N");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "Y":
                    //todo implement restart game
                    play();
                case "N":
                    System.out.println("Exit game.");
                    break;
                default:
                    System.out.println("Wrong input, try again.");
            }
        }
    }

    public static void exit() {
        System.out.println("Do you want to exit the game? Y/N");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toUpperCase();
            switch (input) {
                case "Y":
                    System.out.println("Exit game");
                    System.exit(0);
                case "N":
                    System.out.println("Back to game");
                    break;
                default:
                    System.out.println("Wrong input, try again");
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getRounds() {
        return rounds;
    }

    public String setName() {
        while (true) {
            System.out.println("Enter your name: ");
            Scanner input = new Scanner(System.in);
            String theName = input.nextLine();
            if (theName.length() < 3) {
                System.out.println("Enter at least 3 characters");
            } else {
                System.out.println("Hello " + theName);
                name = theName;
                return theName;
            }
        }
    }

    public int setRounds() {
        while (true) {
            System.out.println("Enter number of rounds between 1 and 10: ");
            Scanner input = new Scanner(System.in);
            try {
                int theRounds = input.nextInt();
                if (theRounds < 1 || theRounds > 10) {
                    System.out.println("Number of rounds needs to be between 1 and 10.");
                } else {
                    System.out.println("Rounds: " + theRounds);
                    rounds = theRounds;
                    return theRounds;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input.");
            }
        }
    }
}