package methodreferences;

import apple.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;

public class MethodReferences {

    public void comparingApples(List<Apple> inventory) {
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        // Is equivalent to...
        inventory.sort(comparing(Apple::getWeight));
    }

    public void stringSort() {
        List<String> stringList =  asList("a", "b", "A", "B");
        stringList.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        // Is equivalent to...
        stringList.sort(String::compareToIgnoreCase);

    }

    public void constructorReferences() {
        List<Integer> weights = asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);
    }

    private static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(f.apply(i));
        }

        return result;
    }
}