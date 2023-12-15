package me.madcabbage.aoc.aoc2022.day2.rps;

import java.util.EnumMap;
import java.util.Map;

public class RoundPrediction {

    // 0 if you lost, 3 if it was a draw, 6 if you won
    private final Choice opponentChoice;
    private final Choice yourChoice;

    public RoundPrediction(Choice opponentChoice, Choice yourChoice) {
        this.opponentChoice = opponentChoice;
        this.yourChoice = yourChoice;
    }

    public int calculateTotalScore() {
        int score = yourChoice.getPoints();
        // did we win?
        score += calculateRoundResultScore();
        // how many points for our play?
        return score;
    }

    private int calculateRoundResultScore() {
        if (opponentChoice.getPlay().equals(Play.playBeatsPlayMap.get(yourChoice.getPlay()))) {
            // win
            return 6;
        } else if (yourChoice.getPlay().equals(Play.playBeatsPlayMap.get(opponentChoice.getPlay()))) {
            // lose
            return 0;
        } else {
            // draw
            return 3;
        }
    }


}
