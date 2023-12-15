package me.madcabbage.aoc;

public abstract class AbstractPart implements IPart {

    protected AbstractDay day;

    protected final void printAnswer(String answer) {
        System.out.println("\t\tanswer: " + answer);
    }

    @Override
    public AbstractDay getDay() {
        if (day == null) {
            System.out.println("get day: " + day);
        }
        return this.day;
    }

    @Override
    public void setDay(AbstractDay day) {
        if (day == null) {
            System.out.println("set day: " + day);
        }
        this.day = day;
    }
}
