package me.madcabbage.aoc.aoc2022.day3.part1;

import me.madcabbage.aoc.AbstractPart;
import me.madcabbage.aoc.aoc2022.day3.rucksack.Rucksack;

import java.util.ArrayList;
import java.util.List;

public class Day3Part1 extends AbstractPart {
    @Override
    public void run(List<String> input) {
        List<Rucksack> rucksacks = parseRucksacks(input);

        int totalPriority = getTotalPriority(rucksacks);
        printAnswer(String.valueOf(totalPriority));
    }

    private List<Rucksack> parseRucksacks(List<String> input) {
        List<Rucksack> rucksacks = new ArrayList<>();

        for(String items : input) {
            rucksacks.add(new Rucksack(items, 1));
        }
        return rucksacks;
    }

    private int getTotalPriority(List<Rucksack> rucksacks) {
        int totalPriority = 0;
        for (var rucksack : rucksacks) {
            totalPriority += rucksack.getTotalPriority();
        }
        return totalPriority;
    }
}
