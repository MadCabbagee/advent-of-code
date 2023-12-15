package me.madcabbage.aoc.aoc2023.day2.part1;

import me.madcabbage.aoc.AbstractPart;
import me.madcabbage.aoc.aoc2023.day2.game.CubeSet;
import me.madcabbage.aoc.aoc2023.day2.game.Game;

import java.util.List;

public class Day2Part1 extends AbstractPart {

    private Game[] allGames;

    @Override
    public void run(List<String> input) {
        // parse input into game objects
        allGames = parseGames(input);

        final CubeSet bag = new CubeSet((byte) 12, (byte) 13, (byte) 14);

        // check if games were possible with certain cube counts
        Game[] possibleGames = findPossibleGames(allGames, bag);

        int totalPossibleGameIds = sumGameIds(possibleGames);
        printAnswer(String.valueOf(totalPossibleGameIds));
    }

    private Game[] parseGames(List<String> input) {
        Game[] games = new Game[input.size()];

        for (int i = 0; i < input.size(); i++) {
            final String line = input.get(i);
            int cubeSetsStartIndex = line.indexOf(':') + 1;
            String unParsedCubeSets = line.substring(cubeSetsStartIndex);
            String[] splitCubeSets = unParsedCubeSets.split(";");
            CubeSet[] cubeSets = parseCubeSets(splitCubeSets);

            byte id = (byte) ((byte) i + 1);
            games[i] = new Game(id, cubeSets);
        }
        return games;
    }

    private CubeSet[] parseCubeSets(String[] splitCubeSets) {
        CubeSet[] parsedCubeSets = new CubeSet[splitCubeSets.length];
        int i = 0;

        for (String unParsedCubeSet : splitCubeSets) {
            String[] colorCounts = unParsedCubeSet.split(",");
            byte red = 0;
            byte green = 0;
            byte blue = 0;

            for (String s : colorCounts) {
                if (s.startsWith(" ")) s = s.substring(1);
                if (s.contains("red")) {
                    red = Byte.parseByte(s.replace(" red", ""));
                } else if (s.contains("blue")) {
                    blue = Byte.parseByte(s.replace(" blue", ""));
                } else if (s.contains("green")) {
                    green = Byte.parseByte(s.replace(" green", ""));
                }
            }
            parsedCubeSets[i++] = new CubeSet(red, green, blue);
        }
        return parsedCubeSets;
    }

    private Game[] findPossibleGames(Game[] allGames, final CubeSet masterBag) {
        int possibleIndex = 0;
        Game[] possible = new Game[allGames.length];
        for (Game game : allGames) {
            if (game.isPossible(masterBag)) {
                possible[possibleIndex++] = game;
            }
        }
        return possible;
    }

    private int sumGameIds(Game[] possibleGames) {
        int idsSum = 0;

        for (Game g : possibleGames) {
            if (g != null) {
                idsSum += g.getId();
            }
        }
        return idsSum;
    }

    public Game[] getAllGames() {
        return this.allGames;
    }
}
