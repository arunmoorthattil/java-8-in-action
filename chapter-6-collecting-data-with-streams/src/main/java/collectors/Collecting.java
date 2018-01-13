package collectors;

import dish.Dish;
import dish.Dish.CaloricLevel;
import dish.Dish.Type;
import finance.Currency;
import finance.Transaction;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class Collecting {

    public void imperativeCollecting(List<Transaction> transactions) {
        Map<Currency, List<Transaction>> transactionsByCurrency = new HashMap<>();

        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrency.get(currency);

            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrency.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }
    }

    public void functionalCollecting(List<Transaction> transactions) {
        Map<Currency, List<Transaction>> transactionsByCurrency = transactions.stream()
                                                                              .collect(groupingBy(Transaction::getCurrency));
    }

    public void collectingToList(List<Transaction> transactionList) {
        List<Transaction> transactions = transactionList.stream()
                                                        .collect(Collectors.toList());
    }

    public void collectingCount(List<Transaction> transactions) {
        long numberOfTransactions = transactions.stream()
                                                .collect(Collectors.counting());
        // This is the same as...
        numberOfTransactions = transactions.stream()
                                           .count();
    }

    public void collectingMinAndMac(List<Dish> menu) {
        Comparator<Dish> dishCaloriesComparator = comparingInt(Dish::getCalories);

        Optional<Dish> max = menu.stream()
                                 .collect(Collectors.maxBy(dishCaloriesComparator));

        Optional<Dish> min = menu.stream()
                                 .collect(Collectors.minBy(dishCaloriesComparator));
    }

    public void collectinSum(List<Dish> menu) {
        int totalCalories = menu.stream()
                                .collect(Collectors.summingInt(Dish::getCalories));
    }

    public void collectinAverage(List<Dish> menu) {
        double averageCalories = menu.stream()
                                     .collect(Collectors.averagingInt(Dish::getCalories));
    }

    public void summarizingInt(List<Dish> menu) {
        IntSummaryStatistics stats = menu.stream()
                                         .collect(summarizingInt(Dish::getCalories));
    }

    public void joiningStrings(List<Dish> menu) {
        String shortMenu = menu.stream()
                               .map(Dish::getName)
                               .collect(joining());
        // Same as...
        shortMenu = menu.stream()
                        .collect(joining());

        // Delimited
        shortMenu = menu.stream()
                        .map(Dish::getName)
                        .collect(joining(", "));
    }

    public void collectingWithReductiom(List<Dish> menu) {
        int totalCalories = menu.stream()
                                .collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));

        Optional<Dish> highestCalorieDish = menu.stream()
                                                .collect(Collectors.reducing((d1, d2) -> d1.getCalories() >
                                                        d2.getCalories() ? d1 : d2));
    }

    public void collectionFrameworkFlexibility(List<Dish> menu) {
        int totalCalories = menu.stream()
                                .collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        // is the same as...
        totalCalories = menu.stream()
                            .map(Dish::getCalories)
                            .reduce(Integer::sum)
                            .get();
        // To avoid using Optional.get()...
        totalCalories = menu.stream()
                            .mapToInt(Dish::getCalories)
                            .sum();
    }

    public void groupingUsingCollectionFramework(List<Dish> menu) {
        Map<Type, List<Dish>> dishesByType = menu.stream()
                                                 .collect(groupingBy(Dish::getType));

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                                                                 .collect(groupingBy(dish -> {
                                                                     if (dish.getCalories() <= 400) {
                                                                         return CaloricLevel.DIET;
                                                                     } else if (dish.getCalories() <= 700) {
                                                                         return CaloricLevel.NORMAL;
                                                                     } else {
                                                                         return CaloricLevel.FAT;
                                                                     }
                                                                 }));

        // Mulit-level grouping...
        Map<Type, Map<CaloricLevel, List<Dish>>> dishesByTypesCaloricLevel = menu.stream()
                                                                                 .collect
                                                                                         (groupingBy(Dish::getType, groupingBy(dish -> {
                                                                                             if (dish.getCalories() <= 400) {
                                                                                                 return CaloricLevel.DIET;
                                                                                             } else if (dish.getCalories() <= 700) {
                                                                                                 return CaloricLevel.NORMAL;
                                                                                             } else {
                                                                                                 return CaloricLevel.FAT;
                                                                                             }
                                                                                         })));
    }

    public void collectingSubGroups(List<Dish> menu) {
        Map<Type, Long> typesCount = menu.stream()
                                         .collect(groupingBy(Dish::getType, Collectors.counting()));

        Map<Type, Optional<Dish>> mostCaloricByTypeOpt = menu.stream()
                                                             .collect(groupingBy(Dish::getType, Collectors.maxBy
                                                                     (comparingInt(Dish::getCalories))));

        Map<Type, Dish> mostCaloricByType = menu.stream()
                                                .collect(groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.maxBy
                                                        (comparingInt(Dish::getCalories)), Optional::get)));

        Map<Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream()
                                                               .collect(groupingBy(Dish::getType, Collectors.mapping(dish -> {
                                                                           if (dish.getCalories() <= 400)
                                                                               return CaloricLevel.DIET;
                                                                           else if (dish.getCalories() <= 700)
                                                                               return CaloricLevel.NORMAL;
                                                                           else return CaloricLevel.FAT;
                                                                       }, Collectors.toCollection(HashSet::new)
                                                               )));
    }

    public void partitioningViaCollectors(List<Dish> menu) {
        Map<Boolean, List<Dish>> partitionMenu = menu.stream()
                                                     .collect(Collectors.partitioningBy(Dish::isVegetarian));

        List<Dish> vegetarianDishes = menu.stream()
                                          .filter(Dish::isVegetarian)
                                          .collect(Collectors.toList());

        Map<Boolean, Map<Type, List<Dish>>> vegetarianDishesByType = menu.stream()
                                                                         .collect(Collectors.partitioningBy
                                                                                 (Dish::isVegetarian, groupingBy(Dish::getType)));

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
                                                                    .collect(Collectors.partitioningBy
                                                                            (Dish::isVegetarian, Collectors.collectingAndThen
                                                                                    (Collectors.maxBy(comparingInt(Dish::getCalories)), Optional::get)));
    }
}