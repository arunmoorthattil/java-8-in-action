package apple.filter;

import apple.Apple;
import apple.filter.predicate.ApplePredicate;

import java.util.List;

public class AppleFilterAttempt5 {

    /**
     * Filtering apples in-line using annoymous classes.
     */
    public void filterApples(List<Apple> inventory) {
        List<Apple> redApples = AppleFilterAttempt4.filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColour());
            }
        });
    }
}
