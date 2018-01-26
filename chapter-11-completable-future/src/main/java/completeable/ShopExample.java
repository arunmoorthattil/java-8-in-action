package completeable;

import completeable.asynchronous.Discount;
import completeable.asynchronous.Quote;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import static completeable.asynchronous.Discount.applyDiscount;
import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.stream.Collectors.toList;

public class ShopExample {
    public void singleShop() {
        Shop shop = new Shop("Best Shop");
        long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsync("my favourite product");

        long invocationTime = ((System.nanoTime() - start) / 1_000_000);

        System.out.println("Invocation returned after " + invocationTime + " msecs");

        // Do some more tasks, like querying other shops
        doSomethingElse();
        // while the price of th eproduct is being calculated
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public void multipleShops(String product) {
        List<Shop> shopList = asList(new Shop("Best Price"), new Shop("Lets Save Big"), new Shop("My Favourite " +
                "Shop"), new Shop("Buy It All"));

        List<String> pricesByShop = findPrices(shopList, product);
    }

    private List<String> findPrices(List<Shop> shopList, String product) {
        return shopList.parallelStream()
                       .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                       .collect(toList());
    }

    private List<String> findPricesUsingCompletableFuture(List<Shop> shopList, String product) {
        List<CompletableFuture<String>> pricesFuture = shopList.stream()
                                                               .map(shop -> supplyAsync(() -> String.format("%s price is %.2f", shop.getName
                                                                       (), shop.getPrice(product))))
                                                               .collect(toList());

        return pricesFuture.stream()
                           .map(CompletableFuture::join)
                           .collect(toList());
    }

    private void findPricesWithDiscountStreamAsync(List<Shop> shopList, String product) {
        List<CompletableFuture<Void>> futures = findPricesWithDiscountStream(shopList, product).map(f -> f.thenAccept(System.out::println))
                                                                                               .collect(toList());

        CompletableFuture.allOf((CompletableFuture<?>) futures).join();
    }

    public Stream<CompletableFuture<String>> findPricesWithDiscountStream(List<Shop> shopList, String product) {
        Executor executor = Executors.newCachedThreadPool();

//        return shopList.stream()
//                       .map(shop -> supplyAsync(() -> shop.getPrice(product), executor))
//                       .map(future -> (CompletableFuture<Quote>) future.thenApply(Quote::parse))
//                       .map(future -> future.thenCompose(quote -> supplyAsync(() ->
//                               applyDiscount(quote), executor)));
        return Stream.empty();
    }

    public List<String> findPricesWithDiscountAsync(List<Shop> shopList, String product) {
        Executor executor = Executors.newCachedThreadPool();

//        List<CompletableFuture<String>> futures = shopList.stream()
//                                                          .map(shop -> supplyAsync(() -> shop.getPrice(product), executor))
//                                                          .map(future -> future.thenApply(Quote::parse))
//                                                          .map(future -> future.thenCompose(quote -> supplyAsync(() ->
//                                                                  applyDiscount(quote), executor)))
//                                                          .collect(toList());
//
//        return futures.stream()
//                      .map(CompletableFuture::join)
//                      .collect(toList());
        return EMPTY_LIST;
    }

    public List<String> findPricesWithDiscount(List<Shop> shopList, String product) {
//        return shopList.stream()
//                       .map(shop -> shop.getPrice(product))
//                       .map(Quote::parse)
//                       .map(Discount::applyDiscount)
//                       .collect(toList());
        return EMPTY_LIST;
    }

    private static void doSomethingElse() {

    }
}
