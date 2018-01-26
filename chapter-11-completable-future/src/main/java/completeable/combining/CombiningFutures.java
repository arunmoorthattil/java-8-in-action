package completeable.combining;

import completeable.Shop;

import java.util.concurrent.Future;

import static completeable.combining.Currency.EUR;
import static completeable.combining.Currency.USD;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class CombiningFutures {
    private ExchangeService exchangeService;

    public void combine(Shop shop, String product) {
        Future<Double> futurePriceInUsd = supplyAsync(() -> shop.getPrice(product))
                                                           .thenCombine(
                                                                   supplyAsync(() -> exchangeService.getRate(EUR, USD)), (price, rate) -> price * rate);
    }
}
