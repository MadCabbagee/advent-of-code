package me.madcabbage.aoc.aoc2022.day2.part2;

import me.madcabbage.aoc.AbstractPart;
import me.madcabbage.aoc.aoc2022.day2.Day2;
import me.madcabbage.aoc.aoc2022.day2.rps.Choice;
import me.madcabbage.aoc.aoc2022.day2.rps.Result;
import me.madcabbage.aoc.aoc2022.day2.rps.RoundPrediction;

import java.util.ArrayList;
import java.util.List;

public class Day2Part2 extends AbstractPart {
    @Override
    public void run(List<String> input) {
        List<RoundPrediction> strategyGuide = parseRoundPredictions(input);
        int totalScore = Day2.calculateScoreForAllRounds(strategyGuide);

        printAnswer(String.valueOf(totalScore));
    }

    private List<RoundPrediction> parseRoundPredictions(List<String> input) {
        List<RoundPrediction> strategyGuide = new ArrayList<>();

        for (String line : input) {
            var opponentChoice = new Choice(line.charAt(0));
            var desiredResult = new Result(line.charAt(2), opponentChoice.getPlay());
            var yourChoice = new Choice(desiredResult.getPlay());
            strategyGuide.add(new RoundPrediction(opponentChoice, yourChoice));
        }

        return strategyGuide;
    }
}
