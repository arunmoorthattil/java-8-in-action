package numeric;

import dish.Dish;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.sqrt;
import static java.util.Arrays.*;
import static java.util.stream.Stream.of;

public class NumericStreams {

    public void summing(List<Dish> menu) {
        int calories = menu.stream()
                           .map(Dish::getCalories)
                           .reduce(0, Integer::sum);
        // Is equivalent to...
        calories = menu.stream()
                       .mapToInt(Dish::getCalories)
                       .sum();
    }

    public void primitveToGenericStream(List<Dish> menu) {
        IntStream intStream = menu.stream()
                                  .mapToInt(Dish::getCalories);
        // Map back to boxed stream...
        Stream<Integer> steam = intStream.boxed();
    }

    public void defaultValuesAndOptionalInt(List<Dish> menu) {
        OptionalInt maxCalories = menu.stream()
                                      .mapToInt(Dish::getCalories)
                                      .max();
    }

    public void numericRanges() {
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                                         .filter(n -> n % 2 == 0);
    }

    public void buildingStreamsFromValues() {
        Stream<String> stream = of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase)
              .forEach(System.out::println);
    }

    public void buildingStreamsFromArrays() {
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = stream(numbers).sum();
    }

    public void buildingStreamsFromFiles() {
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> stream(line.split(" ")))
                               .distinct()
                               .count();
        } catch (IOException e) {}
    }

    public void buldingStreamsFromFunctions() {
        Stream.iterate(0, n -> n + 2)
              .limit(10)
              .forEach(System.out::println);

        Stream.generate(Math::random)
              .limit(5)
              .forEach(System.out::println);
    }
}
