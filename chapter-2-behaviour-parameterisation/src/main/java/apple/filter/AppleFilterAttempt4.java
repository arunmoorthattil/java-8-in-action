package apple.filter;

import apple.Apple;
import apple.filter.predicate.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class AppleFilterAttempt4 {

    /**
     * This implementation allows the filtering logic for apples to be passed in as
     * an argument, see the {@link ApplePredicate} parameter. This solution relies
     * on behaviour parameterisation.
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) { // This is where the magic happens!
                result.add(apple);
            }
        }

        return result;
    }
}
