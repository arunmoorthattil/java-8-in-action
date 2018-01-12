package finance;

import finance.traders.Trader;
import finance.transaction.Transaction;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class FinanceStreams {

    private Trader raoul = new Trader("Raoul", "Cambridge");
    private Trader mario = new Trader("Mario", "Milan");
    private Trader alan = new Trader("Alan", "Cambridge");
    private Trader brian = new Trader("Brain", "Cambridge");

    private List<Transaction> transactions = asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    private void findAll2011Transactions() {
        List<Transaction> result = transactions.stream()
                                               .filter(t -> t.getYear() == 2011)
                                               .sorted(comparing(Transaction::getValue))
                                               .collect(toList());
    }

    private void tradersCities() {
        List<String> result = transactions.stream()
                                          .map(Transaction::getTrader)
                                          .map(Trader::getCity)
                                          .distinct()
                                          .collect(toList());
    }

    private void cambridgeTradersSorted() {
        List<Trader> result = transactions.stream()
                                          .map(Transaction::getTrader)
                                          .distinct()
                                          .filter(t -> t.getCity()
                                                        .equalsIgnoreCase("Cambridge"))
                                          .sorted(comparing(Trader::getName))
                                          .collect(toList());
    }

    private void traderNamesSorted() {
        String result = transactions.stream()
                                    .map(t -> t.getTrader()
                                               .getName())
                                    .distinct()
                                    .sorted()
                                    .reduce("", (s1, s2) -> s1 + ", " + s2);
    }

    private void areTradersBasedInMilan() {
        boolean basedInMilan = transactions.stream()
                                           .anyMatch(t -> t.getTrader()
                                                           .getCity()
                                                           .equalsIgnoreCase("Milan"));
    }

    private void transactionForCambridgeTraders() {
        transactions.stream()
                    .filter(t -> t.getTrader()
                                  .getCity()
                                  .equalsIgnoreCase("Cambridge"))
                    .map(Transaction::getValue)
                    .forEach(System
                            .out::println);
    }

    private void highestTransactionValue() {
        Optional<Integer> highest = transactions.stream()
                                                .map(Transaction::getValue)
                                                .reduce(Integer::max);
    }

    private void lowestTransaction() {
        Optional<Transaction> result = transactions.stream()
                                                   .min(comparing(Transaction::getValue));
    }
}
