package apple.filter;

import apple.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleFilterAttempt3 {

    /**
     * This implementation attempts to amalgamate {@link AppleFilterAttempt2#filterApplesByColour(List, String)}
     * and {@link AppleFilterAttempt2#filterApplesByWeight(List, int)} into a single method. As
     * can be seen this leads to some pretty ugly filtering and the use of a boolean flag! This method is
     * not maintainable and is, therefore, not a great design!
     */
    public static List<Apple> filterApples(List<Apple> inventory, String colour, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ( (flag && apple.getColour().equals(colour)) ||
                    (!flag && apple.getWeight() >  weight)) {
                result.add(apple);
            }
        }

        return result;
    }
}
