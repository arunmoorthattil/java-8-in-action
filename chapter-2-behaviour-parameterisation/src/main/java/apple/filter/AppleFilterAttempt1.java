package apple.filter;

import apple.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleFilterAttempt1 {

    /**
     * First attempt at filtering a list of apples by a given predicate,
     * this version is limited and will create maintenance issues if another
     * filtering is required and this is "re-used" by reimplementing this method
     * with different filter criteria. This version also relies on a hard-coded
     * filter which isn't ideal, what if the client wishes to filter for
     * "red" apples rather than "green" apples?
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColour())) {
                result.add(apple);
            }
        }

        return result;
    }
}
