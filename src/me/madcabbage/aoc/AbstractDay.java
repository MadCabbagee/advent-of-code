package me.madcabbage.aoc;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class AbstractDay<T> implements IDay {

    protected final byte day;
    protected final IPart<T> partOne;
    protected final IPart<T> partTwo;
    protected final Path inputPath;

    protected AbstractDay(byte day, IPart<T> partOne, IPart<T> partTwo) {
        this.day = day;
        this.partOne = partOne;
        this.partTwo = partTwo;
        this.inputPath = Paths.get("day" + day, "input.txt");
    }

    @Override
    public void run() {
        T parsedInput = parseInput();
        System.out.println("Day " + day + ":");
        System.out.println("\tPart 1:");
        partOne.run(parsedInput);
        System.out.println("\tPart 2:");
        partTwo.run(parsedInput);
        System.out.println();
    }

    protected abstract T parseInput();
}
