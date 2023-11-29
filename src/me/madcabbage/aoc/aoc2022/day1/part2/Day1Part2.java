package me.madcabbage.aoc.aoc2022.day1.part2;

import me.madcabbage.aoc.AbstractPart;

import java.util.Collections;
import java.util.List;

public class Day1Part2 extends AbstractPart<List<Integer>> {
    @Override
    public void run(List<Integer> parsedInput) {
        int largestSum = 0;
        for (int i = 0; i < 3; i++ ) {
            // get largest
            int largest = Collections.max(parsedInput);
            // store largest
            largestSum += largest;
            // remove largest
            parsedInput.remove((Integer)largest);
        }
        printAnswer(String.valueOf(largestSum));
    }
}
