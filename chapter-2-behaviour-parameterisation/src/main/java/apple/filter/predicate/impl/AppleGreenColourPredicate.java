package apple.filter.predicate.impl;

import apple.Apple;
import apple.filter.predicate.ApplePredicate;

public class AppleGreenColourPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColour());
    }
}
