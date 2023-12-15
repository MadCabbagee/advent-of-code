package me.madcabbage.aoc;

import me.madcabbage.aoc.aoc2022.AOC2022;
import me.madcabbage.aoc.aoc2023.AOC2023;

public class Main {
    public static void main(String[] args) {
        runAllYears();
    }

    private static void runAllYears() {
        new AOC2022().runAll();
        new AOC2023().runAll();
    }
}

/*public class Main {

    private static final List<AbstractDay> days = new ArrayList<>();
    public static void main(String[] args) {
        runAllDays();
    }

    private static void runAllDays() {
        for (var day : days) {
            day.run();
        }
    }

    public static void addDay(AbstractDay day) {
        days.add(day);
    }

}*/

/*public class Main {

    private static Main instance;
    private final List<AbstractDay> days = new ArrayList<>();

    private Main() {
        if (instance != null) {
            throw new IllegalStateException("Singleton instance already created. Use getInstance() method.");
        }
        instance = this;
    }

    public static void main(String[] args) {
        getInstance().runAllDays();
    }

    private void runAllDays() {
        for (var day : days) {
            day.run();
        }
    }

    public void addDay(AbstractDay day) {
        days.add(day);
    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

}*/
