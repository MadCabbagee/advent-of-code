package me.madcabbage.aoc.aoc2022.day2;

import me.madcabbage.aoc.AbstractDay;
import me.madcabbage.aoc.aoc2022.day2.part1.Day2Part1;
import me.madcabbage.aoc.aoc2022.day2.part2.Day2Part2;
import me.madcabbage.aoc.aoc2022.day2.rps.RoundPrediction;

import java.util.List;

public class Day2 extends AbstractDay {
    public Day2() {
        super((short) 2022, (byte) 2, new Day2Part1(), new Day2Part2());
    }

    public static void main(String[] args) {
        new Day2().run();
    }

    public static int calculateScoreForAllRounds(List<RoundPrediction> strategyGuide) {
        int totalScore = 0;
        for (RoundPrediction rp : strategyGuide) {
            totalScore += rp.calculateTotalScore();
        }
        return totalScore;
    }
}
