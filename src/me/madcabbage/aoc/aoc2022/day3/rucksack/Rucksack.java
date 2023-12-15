package me.madcabbage.aoc.aoc2022.day3.rucksack;

import java.util.HashMap;
import java.util.Map;

public class Rucksack {

    private static final Map<Character, Integer> priorities = new HashMap<>();

    static {
        // Initialize priority sets
        char currentLowercase = 'a';
        char currentUppercase = 'A';
        for (int i = 1; i <= 26; i++) {
            priorities.put(currentLowercase, i);
            currentLowercase++;

            priorities.put(currentUppercase, i);
            currentUppercase++;
        }
    }

    private char[] compartmentOne;
    private char[] compartmentTwo;
    private char[] duplicateItems;
    private int duplicatePriority;
    private int expectedDuplicates;
    public Rucksack(String items, int expectedDuplicates) {
        compartmentOne = items.substring(0, items.length()/2).toCharArray();
        compartmentTwo = items.substring(items.length()/2+1).toCharArray();
        this.expectedDuplicates = expectedDuplicates;
       // findDuplicateItems();
       // calculatePriorityOfDuplicates();
    }

    private void findDuplicateItems() {
        int duplicateIndex = 0;
        duplicateItems = new char[expectedDuplicates];
        for (int i = 0; i < compartmentTwo.length; i++) {
            char firstCompartmentItem = compartmentOne[i];
            char secondCompartmentItem = compartmentTwo[i];

            if (firstCompartmentItem == secondCompartmentItem) {
                duplicateItems[duplicateIndex] = firstCompartmentItem;
                duplicateIndex++;
            }
        }
    }

    private void calculatePriorityOfDuplicates() {
        for (char item : duplicateItems) {
            //duplicatePriority += calculatePriority(item);
        }
    }

   /* public static int calculatePriority(char itemType) {
        if (LOWERCASE_PRIORITY_SET.contains(itemType)) {
            return itemType - 'a' + 1;
        } else if (UPPERCASE_PRIORITY_SET.contains(itemType)) {
            return itemType - 'A' + 27;
        } else {
            return 0; // Handle unexpected characters
        }
    }*/

    public int getTotalPriority() {
        return duplicatePriority;
    }
}
