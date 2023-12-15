package me.madcabbage.aoc.aoc2022.day2.rps;
public class Choice {

    // opponent: a for rock, b for paper, c for scissors
    // you: x for rock, y for paper, z for scissors
    private final Play play;

    public Choice(Play play) {
        this.play = play;
    }

    public Choice(char code) {
        switch (Character.toLowerCase(code)) {
            case 'a', 'x' -> this.play = Play.Rock;
            case 'b', 'y' -> this.play = Play.Paper;
            case 'c', 'z' -> this.play = Play.Scissors;
            default -> throw new IllegalStateException("Unexpected value: " + code);
        }
    }

    public int getPoints() {
        return play.getPoints();
    }

    public Play getPlay() {
        return play;
    }
}
