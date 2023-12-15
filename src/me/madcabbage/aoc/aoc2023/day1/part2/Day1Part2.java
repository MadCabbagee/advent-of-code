package me.madcabbage.aoc.aoc2023.day1.part2;

import me.madcabbage.aoc.AbstractPart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1Part2 extends AbstractPart {

    private static final String[] numbersWords = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final Map<String, Byte> wordNumberMap = new HashMap<>();
    static {
        populateNumberMap();
    }

    private static void populateNumberMap() {
        byte i = 0;
        while (i < numbersWords.length) {
            wordNumberMap.put(numbersWords[i], ++i);
        }
    }

    @Override
    public void run(List<String> input) {
        int totalCalibrationValue = 0;
        for (String s : input) {
            byte firstNumber = findFirst(s);
            byte lastNumber = findLast(s);
            totalCalibrationValue += firstNumber * 10 + lastNumber;
        }
        printAnswer(String.valueOf(totalCalibrationValue));
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
            } else {
                for (String s : numbersWords) {
                    if (input.startsWith(s, i)) {
                        return wordNumberMap.get(s);
                    }
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
