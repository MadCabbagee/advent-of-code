package me.madcabbage.aoc;

import java.util.List;

public interface IPart {
    void run(List<String> input);

    AbstractDay getDay();

    void setDay(AbstractDay day);
}
