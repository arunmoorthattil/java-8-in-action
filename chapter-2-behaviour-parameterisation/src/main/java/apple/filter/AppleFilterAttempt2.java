package apple.filter;

import apple.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleFilterAttempt2 {

    /**
     * Slightly better implementation compare to {@link AppleFilterAttempt1#filterGreenApples(List)}
     * as this method now allows the same implementation to be used for different colours.
     * This doesn't go far enough as {@link AppleFilterAttempt2#filterApplesByWeight(List, int)}
     * illustrates.
     */
    public static List<Apple> filterApplesByColour(List<Apple> inventory, String colour) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (colour.equals(apple.getColour())) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * This is a bad implementation as it essentially implements this new filtering
     * using the same boiler plate code used in {@link AppleFilterAttempt2#filterApplesByColour(List, String)}.
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }

        return result;
    }
}
