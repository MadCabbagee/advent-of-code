package me.madcabbage.aoc.aoc2022.day1;

import me.madcabbage.aoc.AbstractDay;
import me.madcabbage.aoc.aoc2022.day1.part1.Day1Part1;
import me.madcabbage.aoc.aoc2022.day1.part2.Day1Part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class InvalidCalorieException extends RuntimeException {
    public InvalidCalorieException(String message) {
        super(message);
    }
}
public class Day1 extends AbstractDay<List<Integer>> {
    public Day1() {
        super((byte) 1, new Day1Part1(), new Day1Part2());
    }

    @Override
    protected List<Integer> parseInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(Day1.class.getClassLoader().getResourceAsStream(inputPath.toString()))));
        List<Integer> calorieSums = new ArrayList<>();
        int tempSum = 0;
        try {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    calorieSums.add(tempSum);
                    tempSum = 0;
                } else {
                    tempSum += Integer.parseInt(line);
                }
            }
            br.close();
        } catch (IOException | NumberFormatException e) {
            throw new InvalidCalorieException("Calorie could not be parsed");
        }
        return calorieSums;
    }

    public static void main(String[] args) {
        new Day1().run();
    }

}
