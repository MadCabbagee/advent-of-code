package me.madcabbage.aoc.aoc2022.day1.part2;

import me.madcabbage.aoc.AbstractPart;
import me.madcabbage.aoc.aoc2022.day1.Day1;
import me.madcabbage.aoc.aoc2022.day1.exceptions.InvalidCalorieException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1Part2 extends AbstractPart {
    @Override
    public void run(List<String> input) {
        List<Integer> integerInput = Day1.sumCalorieGroups(input);
        // sum of top 3 largest calorie sums
        int calorieSum = 0;
        for (int i = 0; i < 3; i++ ) {
            // get largest
            int largest = Collections.max(integerInput);
            // store largest
            calorieSum += largest;
            // remove largest
            integerInput.remove((Integer)largest);
        }
        printAnswer(String.valueOf(calorieSum));
    }
}
