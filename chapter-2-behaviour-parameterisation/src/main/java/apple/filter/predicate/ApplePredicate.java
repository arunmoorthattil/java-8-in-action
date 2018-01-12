package apple.filter.predicate;

import apple.Apple;

@FunctionalInterface
public interface ApplePredicate {
    boolean test(Apple apple);
}
