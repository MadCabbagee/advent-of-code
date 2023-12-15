package me.madcabbage.aoc.aoc2023.day2.game;

import java.util.Arrays;

public class Game {
    private final byte id;
    private final CubeSet[] cubeSets;

    public Game(byte id, CubeSet[] cubeSets) {
        this.id = id;
        this.cubeSets = cubeSets;
    }

    public boolean isPossible(final CubeSet masterBag) {
        boolean possible;
        for (CubeSet cs : cubeSets) {
            possible = masterBag.getRed() - cs.getRed() > -1 && masterBag.getGreen() - cs.getGreen() > -1 && masterBag.getBlue() - cs.getBlue() > -1;
            if (!possible) return false;
        }
        return true;
    }

    public int getId() {
        return this.id;
    }

    public CubeSet[] getCubeSets() {
        return this.cubeSets;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", cubeSets=" + Arrays.toString(cubeSets) +
                '}';
    }
}
