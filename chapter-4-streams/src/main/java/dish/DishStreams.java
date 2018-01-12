package dish;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class DishStreams {

    public void threeHighestCalorieDishes(List<Dish> menu) {
        List<String> result = menu.stream()
                                  .filter(d -> d.getCalories() > 300)
                                  .map(Dish::getName)
                                  .limit(3)
                                  .collect(toList());
    }

    public void threeHighestCalorieDishesWithOutput(List<Dish> menu) {
        List<String> result = menu.stream()
                                  .filter(d -> {
                                          System.out.println("filtering " + d.getName());
                                          return d.getCalories() > 300;
                                  })
                                  .map(d -> {
                                      System.out.println("Mapping " + d.getName());
                                      return d.getName();
                                  })
                                  .limit(3)
                                  .collect(toList());
    }
}
