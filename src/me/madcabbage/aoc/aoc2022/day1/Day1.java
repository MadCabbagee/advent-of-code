package me.madcabbage.aoc.aoc2022.day1;

import me.madcabbage.aoc.AbstractDay;
import me.madcabbage.aoc.Main;
import me.madcabbage.aoc.aoc2022.day1.exceptions.InvalidCalorieException;
import me.madcabbage.aoc.aoc2022.day1.part1.Day1Part1;
import me.madcabbage.aoc.aoc2022.day1.part2.Day1Part2;

import java.util.ArrayList;
import java.util.List;

public class Day1 extends AbstractDay {
    public Day1() {
        super((short) 2022, (byte) 1, new Day1Part1(), new Day1Part2());
    }

    public static void main(String[] args) {
        new Day1().run();
    }

    public static List<Integer> sumCalorieGroups(List<String> input) {
        List<Integer> calorieSums = new ArrayList<>();
        int tempSum = 0;

        for (String line : input) {
            if (line.isEmpty()) {
                calorieSums.add(tempSum);
                tempSum = 0;
            } else {
                try {
                    tempSum += Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    throw new InvalidCalorieException("Error parsing calories into integers.");
                }
            }
        }

        return calorieSums;
    }

}
