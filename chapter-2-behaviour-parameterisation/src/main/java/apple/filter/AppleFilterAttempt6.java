package apple.filter;

import apple.Apple;

import java.util.List;

public class AppleFilterAttempt6 {

    /**
     * Re-implementing {@link AppleFilterAttempt5#filterApples(List)} using lambdas instead of
     * annoymous classes.
     */
    public static List<Apple> filterApples(List<Apple> inventory) {
        List<Apple> redApples = AppleFilterAttempt4.filterApples(inventory, (Apple apple) -> "red".equals(apple
                .getColour()));

        return redApples;
    }
}
