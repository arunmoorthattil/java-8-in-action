package apple.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilterAttempt7 {

    /**
     * Re-implementing {@link AppleFilterAttempt6#filterApples(List)} so that is
     * generic.
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }

        return result;
    }
}
