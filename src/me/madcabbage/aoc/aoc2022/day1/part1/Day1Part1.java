package me.madcabbage.aoc.aoc2022.day1.part1;

import me.madcabbage.aoc.AbstractPart;
import me.madcabbage.aoc.aoc2022.day1.Day1;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day1Part1 extends AbstractPart {
    @Override
    public void run(List<String> input) {
        List<Integer> integerInput = Day1.sumCalorieGroups(input);
        // What is the total number of Calories carried by the Elf with the highest calorie count?
        int largest = Collections.max(integerInput);
        printAnswer(String.valueOf(largest));
    }
}
