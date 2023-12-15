package me.madcabbage.aoc.aoc2022;

import me.madcabbage.aoc.AbstractYear;
import me.madcabbage.aoc.IYear;
import me.madcabbage.aoc.aoc2022.day1.Day1;
import me.madcabbage.aoc.aoc2022.day2.Day2;
import me.madcabbage.aoc.aoc2022.day3.Day3;

public class AOC2022 extends AbstractYear {

    public AOC2022() {
        super((short) 2022);
    }

    public static void main(String[] args) {
        new AOC2022().runAll();
    }

    public void runAll() {
        super.runAll();
        new Day1().run();
        new Day2().run();
        new Day3().run();
    }
}
