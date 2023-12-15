package me.madcabbage.aoc;

public class AbstractYear implements IYear {

    protected short year;

    protected AbstractYear(short year) {
        this.year = year;
    }

    protected void printYearHeader() {
        System.out.println("********* " + year + " *********\n");
    }

    @Override
    public void runAll() {
        printYearHeader();
    }
}
