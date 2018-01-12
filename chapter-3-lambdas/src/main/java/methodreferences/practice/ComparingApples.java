package methodreferences.practice;

import apple.Apple;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

public class ComparingApples {

    public void compareApples1(List<Apple> inventory) {
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
    }

    public void compareApples2(List<Apple> inventory) {
        inventory.sort(comparing(Apple::getWeight));
    }

    public void comapreApples3(List<Apple> inventory) {
        inventory.sort(comparing(Apple::getWeight));
    }
}
