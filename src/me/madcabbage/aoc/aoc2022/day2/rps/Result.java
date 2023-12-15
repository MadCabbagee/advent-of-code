package me.madcabbage.aoc.aoc2022.day2.rps;

public class Result {

    private final Play play;
    public Result(char code, Play opponentPlay) {

        switch (Character.toLowerCase(code)) {
            // lose
            case 'x' -> this.play = Play.playBeatsPlayMap.get(opponentPlay);
            // draw
            case 'y' -> this.play = opponentPlay;
            // win
            case 'z' -> this.play = Play.playBeatsPlayMap.get(Play.playBeatsPlayMap.get(opponentPlay));
            default -> throw new IllegalStateException();
        }
    }

    public Play getPlay() {
        return this.play;
    }
}
