package me.madcabbage.aoc.aoc2022.day2.rps;

import java.util.EnumMap;
import java.util.Map;

// 1 for rock, 2 for paper, 3 for scissors
public enum Play {
    Rock(1),
    Paper(2),
    Scissors(3);


    public static final Map<Play, Play> playBeatsPlayMap = new EnumMap<>(Play.class);
    static {
        playBeatsPlayMap.put(Play.Rock, Play.Scissors);
        playBeatsPlayMap.put(Play.Paper, Play.Rock);
        playBeatsPlayMap.put(Play.Scissors, Play.Paper);
    }
    private final int points;
    Play(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
