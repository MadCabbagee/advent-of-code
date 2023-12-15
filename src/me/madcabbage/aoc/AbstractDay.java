package me.madcabbage.aoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractDay implements IDay {

    protected final short year;
    protected final byte day;
    protected final IPart partOne;
    protected final IPart partTwo;
    protected final Path inputPath;

    protected AbstractDay(short year, byte day, IPart partOne, IPart partTwo) {
        this.year = year;
        this.day = day;
        this.partOne = partOne;
        this.partOne.setDay(this);

        this.partTwo = partTwo;
        this.partTwo.setDay(this);

        this.inputPath = Paths.get(String.valueOf(year) ,"day" + day, "input.txt");

        //Main.addDay(this);
    }

    @Override
    public void run() {
        List<String> inputLines = readInput();

        System.out.println("Day " + day + ":");
        System.out.println("\tPart 1:");

        long p1StartTime = System.currentTimeMillis();
        partOne.run(inputLines);
        long p1StopTime = System.currentTimeMillis();

        long p1RunTime = (p1StopTime - p1StartTime);
        System.out.println("\t\tRuntime: " + p1RunTime + "ms");

        System.out.println("\tPart 2:");
        long p2StartTime = System.currentTimeMillis();
        partTwo.run(inputLines);
        long p2StopTime = System.currentTimeMillis();

        long p2RunTime = (p2StopTime - p2StartTime);
        System.out.println("\t\tRuntime: " + p2RunTime + "ms");

        System.out.println("\tTotal runtime: " + (p1RunTime + p2RunTime) + "ms");

        System.out.println(/* blank for spacing */);
    }

    protected List<String> readInput() {
        List<String> inputLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(AbstractDay.class.getClassLoader().getResourceAsStream(inputPath.toString()))))){
            String line;
            while ((line = br.readLine()) != null) {
                inputLines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputLines;
    }

    @Override
    public IPart getPartOne() {
        return partOne;
    }

    @Override
    public IPart getPartTwo() {
        return partTwo;
    }
}
