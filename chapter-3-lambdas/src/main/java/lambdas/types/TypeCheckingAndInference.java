package lambdas.types;

import apple.Apple;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;

public class TypeCheckingAndInference {
    public void typeCheckingExample() {
        // All of the below are equivalent
        Comparator<Apple> c1 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        ToIntBiFunction<Apple, Apple> c2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        BiFunction<Apple, Apple, Integer> c3 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    }

    public void typeInference() {
        Comparator<Apple> c1 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        // The above is the same as...
        Comparator<Apple> c2 = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
    }
}
