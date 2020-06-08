package rps.thegame;

public class TheGame {
    public static Result checkWinner(Select userMove, Select pcMove) {
        if (userMove == pcMove)
            return Result.TIE;
        else if (userMove == Select.ROCK && pcMove == Select.PAPER)
            return Result.LOSE;
        else if (userMove == Select.PAPER && pcMove == Select.SCISSORS)
            return Result.LOSE;
        else if (userMove == Select.SCISSORS && pcMove == Select.ROCK)
            return Result.LOSE;
        else
            return Result.WIN;
    }

    public static void checkConditions(String name, int rounds) {
        int userWins = 0;
        int pcWins = 0;
        int round = 0;

        if(userWins > round){
            System.out.println("");
        }
        //todo Logic of the game, userMove == Select.QUIT, Select.NEW_GAME

    }
}