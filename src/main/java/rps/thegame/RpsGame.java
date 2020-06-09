package rps.thegame;

import java.util.ArrayList;
import java.util.List;

public class RpsGame {
    public void play() {
        int round = 1;
        int rounds = UserDialogs.getNumberOfRounds();
        int computerScore = 0;
        int humanScore = 0;
        while (round <= rounds) {
            UserSelection userSelection = UserDialogs.getUserSelection();
            if (userSelection == UserSelection.QUIT)
                System.exit(0);
            else if (userSelection == UserSelection.NEW_GAME)
                play();
            UserSelection computerSelection = AI.getComputerSelection();
            Winner winner = selectWinner(computerSelection, userSelection);
            if (winner == Winner.COMPUTER) {
                computerScore++;
            } else if (winner == Winner.HUMAN) {
                humanScore++;
            } else {
                computerScore++;
                humanScore++;
            }
            UserDialogs.showStats(humanScore, computerScore, userSelection, computerSelection, round, rounds, winner);
            round++;
        }
        UserDialogs.showFinalStats(computerScore, humanScore);
    }

    private Winner selectWinner(UserSelection computerSelection, UserSelection userSelection) {
        return getAllSelections().stream()
                .filter(s -> s.getUserSelection() == userSelection)
                .filter(s -> s.getComputerSelection() == computerSelection)
                .map(Selections::getWinner)
                .findFirst()
                .orElse(null);
    }

    private List<Selections> getAllSelections() {
        List<Selections> selections = new ArrayList<>();
        selections.add(new Selections(UserSelection.ROCK, UserSelection.PAPER, Winner.COMPUTER));
        selections.add(new Selections(UserSelection.PAPER, UserSelection.SCISSORS, Winner.COMPUTER));
        selections.add(new Selections(UserSelection.SCISSORS, UserSelection.ROCK, Winner.COMPUTER));
        selections.add(new Selections(UserSelection.ROCK, UserSelection.SCISSORS, Winner.HUMAN));
        selections.add(new Selections(UserSelection.SCISSORS, UserSelection.PAPER, Winner.HUMAN));
        selections.add(new Selections(UserSelection.PAPER, UserSelection.ROCK, Winner.HUMAN));
        selections.add(new Selections(UserSelection.PAPER, UserSelection.PAPER, Winner.BOTH));
        selections.add(new Selections(UserSelection.ROCK, UserSelection.ROCK, Winner.BOTH));
        selections.add(new Selections(UserSelection.SCISSORS, UserSelection.SCISSORS, Winner.BOTH));

        return selections;
    }

    private class Selections {
        private UserSelection userSelection;
        private UserSelection computerSelection;
        private Winner winner;

        public Selections(UserSelection userSelection, UserSelection computerSelection, Winner winner) {
            this.userSelection = userSelection;
            this.computerSelection = computerSelection;
            this.winner = winner;
        }

        public UserSelection getUserSelection() {
            return userSelection;
        }

        public UserSelection getComputerSelection() {
            return computerSelection;
        }

        public Winner getWinner() {
            return winner;
        }
    }
}