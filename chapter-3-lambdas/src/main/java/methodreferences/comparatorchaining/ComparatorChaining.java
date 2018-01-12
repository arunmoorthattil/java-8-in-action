package methodreferences.comparatorchaining;

import apple.Apple;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class ComparatorChaining {

    public void chain(List<Apple> inventory) {
        Comparator<Apple> c = comparing(Apple::getWeight);

        inventory.sort(c.reversed());

        inventory.sort(c.reversed()
                        .thenComparing(Apple::getColour));
    }
}
