package refactoring;

import dish.Dish;
import dish.Dish.CaloricLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.groupingBy;

public class Refactoring {

    public void annoymousClasses() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
    }

    public void lambda() {
        Runnable r1 = () -> System.out.println("Hello");
    }

    public void methodReference(List<Dish> menu) {
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                                                                 .collect(groupingBy(dish -> {
                                                                     if (dish.getCalories() <= 400)
                                                                         return CaloricLevel.DIET;
                                                                     else if (dish.getCalories() <= 700)
                                                                         return CaloricLevel.NORMAL;
                                                                     else return CaloricLevel.FAT;
                                                                 }));

        dishesByCaloricLevel = menu.stream()
                                   .collect(groupingBy(Dish::getCaloricLevel));
    }

    public void imperativeDataProcessing(List<Dish> menu) {
        List<String> dishNames = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() > 300) {
                dishNames.add(dish.getName());
            }
        }
    }

    public void functionalDataProcessing(List<Dish> menu) {
        List<String> dishNames = menu.parallelStream()
                                     .filter(d -> d.getCalories() > 300)
                                     .map(Dish::getName)
                                     .collect(toList());
    }

    public void conditionDeferredExecution() {
        Logger logger = Logger.getLogger("Refactoring");
        if (logger.isLoggable(Level.FINER)) {
            logger.finer("...");
        }

        // Could be done similar to...
        log(Level.FINER, () -> "Problem: " + someExpensiveMethod());
        // This means that the expensive method is not executed until
        // after the check on the level.
    }

    private String someExpensiveMethod() {
        return "";
    }

    private void log(Level level, Supplier<String> msgSupplier) {
        Logger logger = Logger.getLogger("Refactoring");
        if (logger.isLoggable(level)) {
            log(level, msgSupplier.get());
        }
    }

    private void log(Level level, String string) {
        System.out.println(string);
    }
}
