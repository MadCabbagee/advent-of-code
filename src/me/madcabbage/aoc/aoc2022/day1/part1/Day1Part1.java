package me.madcabbage.aoc.aoc2022.day1.part1;

import me.madcabbage.aoc.AbstractPart;

import java.util.Collections;
import java.util.List;

public class Day1Part1 extends AbstractPart<List<Integer>> {
    @Override
    public void run(List<Integer> parsedInput) {
        // What is the total number of Calories carried by the Elf with the highest calorie count?
        int largest = Collections.max(parsedInput);
        printAnswer(String.valueOf(largest));
    }
}
