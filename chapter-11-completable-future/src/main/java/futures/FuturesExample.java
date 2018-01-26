package futures;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class FuturesExample {
    public void example() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Double> future = executorService.submit(new Callable<Double>() {
            public Double call() {
                return doSomeLongComputation();
            }
        });

        doSomethingElse();

        try {
            Double result = future.get(1, SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void doSomethingElse() {

    }

    private Double doSomeLongComputation() {
        return null;
    }
}