package parallel;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Parallelism {

    public long imperative(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }

        return result;
    }

    public long functioanlSequential(long n) {
        return Stream.iterate(1L, i -> i + 1)
                     .limit(n)
                     .reduce(0L, Long::sum);
    }

    public long functionalParallel(long n) {
        return Stream.iterate(1L, i -> i + 1)
                     .limit(n)
                     .parallel()
                     .reduce(0L, Long::sum);
    }

    public long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                         .reduce(0L, Long::sum);
    }

    public long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                         .parallel()
                         .reduce(0L, Long::sum);
    }
}
