package me.madcabbage.aoc.aoc2023.day2.part2;

import me.madcabbage.aoc.AbstractPart;
import me.madcabbage.aoc.IPart;
import me.madcabbage.aoc.aoc2023.day2.game.CubeSet;
import me.madcabbage.aoc.aoc2023.day2.game.Game;
import me.madcabbage.aoc.aoc2023.day2.part1.Day2Part1;

import java.util.List;

public class Day2Part2 extends AbstractPart {

    @Override
    public void run(List<String> input) {
        Day2Part1 d2p1 = getPartOne();

        Game[] allGames = d2p1.getAllGames();
        CubeSet[] minMasterCubeSets = findMinCubes(allGames);
        long totalMinCubeSetsPower = multiplyAllCubeSets(minMasterCubeSets);
        printAnswer(String.valueOf(totalMinCubeSetsPower));
    }

    private long multiplyAllCubeSets(CubeSet[] minMasterCubeSets) {
        long minCubesPower = 0;

        for (CubeSet cs : minMasterCubeSets) {
            minCubesPower += cs.getRed() * cs.getGreen() * cs.getBlue();
        }

        return minCubesPower;
    }

    private CubeSet[] findMinCubes(final Game[] allGames) {
        CubeSet[] minCubes = new CubeSet[allGames.length];
        int i = 0;

        for (Game game : allGames) {
            byte red = 0;
            byte green = 0;
            byte blue = 0;

            CubeSet[] cubeSets = game.getCubeSets();
            for (CubeSet cs : cubeSets) {
                byte redTemp = cs.getRed();
                if (red < redTemp) {
                    red = redTemp;
                }

                byte greenTemp = cs.getGreen();
                if (green < greenTemp) {
                    green = greenTemp;
                }

                byte blueTemp = cs.getBlue();
                if (blue < blueTemp) {
                    blue = blueTemp;
                }
            }
            minCubes[i++] = new CubeSet(red, green, blue);
        }

        return minCubes;
    }

    private Day2Part1 getPartOne() {
        IPart ap = getDay().getPartOne();
        if (ap instanceof Day2Part1 d2p1) {
            return d2p1;
        } else {
            throw new IllegalArgumentException("Expected part one to be an instance of Day2Part1 but it is: " + ap.getClass().getName());
        }
    }


}
