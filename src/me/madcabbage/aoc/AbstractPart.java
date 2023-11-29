package me.madcabbage.aoc;

public abstract class AbstractPart<T> implements IPart<T> {

    protected final void printAnswer(String answer) {
        System.out.println("\t\tanswer: " + answer);
    }
    @Override
    public abstract void run(T parsedInput);
}
