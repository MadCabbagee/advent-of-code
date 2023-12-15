package me.madcabbage.aoc.aoc2023.day2.game;

public class CubeSet {

    private final byte red;
    private final byte green;
    private final byte blue;

    public CubeSet(byte redCount, byte greenCount, byte blueCount) {
        red = redCount;
        green = greenCount;
        blue = blueCount;
    }

    public byte getRed() {
        return red;
    }

    public byte getGreen() {
        return green;
    }

    public byte getBlue() {
        return blue;
    }

    @Override
    public String toString() {
        return "CubeSet{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
