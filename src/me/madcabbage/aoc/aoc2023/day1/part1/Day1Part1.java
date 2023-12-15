package me.madcabbage.aoc.aoc2023.day1.part1;

import me.madcabbage.aoc.AbstractPart;
import java.util.List;

public class Day1Part1 extends AbstractPart {

    @Override
    public void run(List<String> input) {
        int calibrationSum = 0;

        for (String s : input) {
            calibrationSum += findFirst(s) * 10 + findLast(s);
        }
        printAnswer(String.valueOf(calibrationSum));
    }

    private byte findFirst(String input) {
        return findNumber(input, 0, 1);
    }

    private byte findLast(String input) {
        return findNumber(input, input.length() - 1, -1);
    }

    private byte findNumber(String input, int startIndex, int increment) {
        for (int i = startIndex; i >= 0 && i < input.length(); i += increment) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                return (byte) (c - '0');
            }
        }
        throw new IllegalArgumentException();
    }

}
