package me.madcabbage.aoc.aoc2023.day3.part1;

import me.madcabbage.aoc.AbstractPart;

import java.util.List;

public class Day3Part1 extends AbstractPart {

    @Override
    public void run(List<String> input) {
        char[][] schematic = convertTo2dArray(input);

        short[] partNumbers = findPartNumbers(schematic);
        int partSum = sumPartNumbers(partNumbers);
        printAnswer(String.valueOf(partSum));
    }

    private short[] findPartNumbers(char[][] schematic) {
        short[] partNumbers = new short[countNumbers(schematic)];
        for (int i = 0; i < schematic.length; i++) {
            short num = 0;
            byte digits = 0;
            for (int j = 0; j < schematic[i].length; j++) {
                if (Character.isDigit(schematic[i][j])) {
                    if (num == 0) {
                        num = Short.parseShort(String.valueOf(schematic[i][j]));
                        digits = 1;
                    } else {
                        num = (short) (num * 10 + Short.parseShort(String.valueOf(schematic[i][j])));
                        digits++;
                    }
                } else if (num != 0) {
                    // check if its adjacent to a symbol
                    if (isSymbol(schematic[i][j])) {

                    }
                    num = 0;
                }
            }
        }
        return partNumbers;
    }

    private int countNumbers(char[][] schematic) {
        boolean last = false;
        int count = 0;
        for (int i = 0; i < schematic.length; i++) {
            for (int j = 0; j < schematic[i].length; j++) {
                if (Character.isDigit(schematic[i][j])) {
                    if (!last) {
                        count++;
                        last = true;
                    }
                } else {
                    last = false;
                }
            }
        }
        return count;
    }

    private boolean isSymbol(char c) {
        return !Character.isDigit(c) && !Character.isLetter(c) && !Character.isWhitespace(c);
    }

    private int sumPartNumbers(short[] partNumbers) {
        int sum = 0;
        for (short s : partNumbers) {
            sum += s;
        }
        return sum;
    }

    private char[][] convertTo2dArray(List<String> input) {
        char[][] schematic = new char[input.size()][input.get(0).length()];

        // line index
        int li = 0;
        // character index
        int ci = 0;
        for (String s : input) {
            char[] a = s.toCharArray();
            for (char c : a) {
                schematic[li][ci++] = c;
            }
            ci = 0;
            li++;
        }

        return schematic;
    }
}
