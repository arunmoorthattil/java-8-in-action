package dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class DishStreams {

    public void vegetarianDishes(List<Dish> menu) {
        List<Dish> result = menu.stream()
                                .filter(Dish::isVegetarian)
                                .collect(toList());
    }

    public void filteringUnqiueElements() {
        List<Integer> numbers = asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
               .filter(i -> i % 2 == 0)
               .distinct()
               .forEach(System.out::println);
    }

    public void skippingStreams(List<Dish> menu) {
        List<Dish> dishes = menu.stream()
                                .filter(d -> d.getCalories() > 300)
                                .skip(2)
                                .collect(toList());
    }

    public void mappingDishNames(List<Dish> menu) {
        List<String> result = menu.stream()
                                  .map(Dish::getName)
                                  .collect(toList());
    }

    public void mappingDishNameLength(List<Dish> menu) {
        List<Integer> result = menu.stream()
                                   .map(Dish::getName)
                                   .map(String::length)
                                   .collect(toList());

    }

    public void introducingFlatMap(List<String> words) {
        List<String> result = words.stream()
                                   .map(w -> w.split("")) // converts each string into an array
                                   .flatMap(Arrays::stream) // flattens all streams into a single stream
                                   .distinct()
                                   .collect(toList());
    }

    public void allMatch(List<Dish> menu) {
        boolean isHealthy = menu.stream()
                                .allMatch(d -> d.getCalories() < 1000);

    }

    public void noneMatch(List<Dish> menu) {
        boolean isHealthy = menu.stream()
                                .noneMatch(d -> d.getCalories() >= 1000);
    }

    public void filtering(List<Dish> menu) {
        Optional<Dish> dish = menu.stream()
                                  .filter(Dish::isVegetarian)
                                  .findAny();

        // Same as above except the result is printed if one exists.
        menu.stream()
            .filter(Dish::isVegetarian)
            .findAny()
            .ifPresent(System.out::println);
    }

    public void findFirst() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        Optional<Integer> result = numbers.stream()
                                          .map(x -> x * x)
                                          .filter(x -> x % 3 == 0)
                                          .findFirst();
    }

    public void summingElements() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);

        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }

        int streamSum = numbers.stream()
                               .reduce(0, (a, b) -> a + b);

        // The above is equivalent to...
        streamSum = numbers.stream()
                           .reduce(0, Integer::sum);

        // Without defining an initial reduction value the result
        // must be wrapped in an Optional
        Optional<Integer> optStreamSum = numbers.stream()
                                                .reduce(Integer::sum);
    }

    public void maxAndMin() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);

        Optional<Integer> max = numbers.stream()
                                       .reduce(Integer::max);

        Optional<Integer> min = numbers.stream()
                                       .reduce(Integer::min);
    }
}
