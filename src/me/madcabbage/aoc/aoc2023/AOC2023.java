package me.madcabbage.aoc.aoc2023;

import me.madcabbage.aoc.AbstractYear;
import me.madcabbage.aoc.aoc2023.day3.Day3;
import me.madcabbage.aoc.aoc2023.day1.Day1;
import me.madcabbage.aoc.aoc2023.day2.Day2;

public class AOC2023 extends AbstractYear {

    public AOC2023() {
        super((short) 2023);
    }

    public static void main(String[] args) {
        new AOC2023().runAll();
    }

    public void runAll() {
        super.runAll();
        new Day1().run();
        new Day2().run();
        new Day3().run();
    }
}
