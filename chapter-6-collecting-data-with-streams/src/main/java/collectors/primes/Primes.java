package collectors.primes;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Primes {

    public Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n)
                        .boxed()
                        .collect(new PrimesCollector());
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
        return primes.stream()
                     .noneMatch(i -> candidate % i == 0);
    }
}
