package rps.thegame;

import java.util.Random;

public class AI {

    public static UserSelection getComputerSelection() {
        Random rnd = new Random();
        int result = rnd.nextInt(100) + 1;
        if (result < 33)
            return UserSelection.SCISSORS;
        else if (result < 66)
            return UserSelection.PAPER;
        else if (result <= 100)
            return UserSelection.ROCK;
        return null;
    }
}