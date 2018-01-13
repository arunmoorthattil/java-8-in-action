package collectors.list;

import dish.Dish;

import java.util.ArrayList;
import java.util.List;

public class ListCollector {

    public void usingToListCollector(List<Dish> menu) {
        List<Dish> dishes = menu.stream()
                                .collect(new ToListCollector<Dish>());
    }

    public void collectorImplementationWithoutConcreteClass(List<Dish> menu) {
        List<Dish> dishes = menu.stream()
                                .collect(
                                        ArrayList::new, // supplier
                                        List::add, // accumulator
                                        List::addAll); // combiner
    }
}