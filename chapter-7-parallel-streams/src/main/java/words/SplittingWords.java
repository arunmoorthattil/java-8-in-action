package words;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SplittingWords {
    private static final String SENTENCE = "Mary had a little lamb.";

    public void splitWords() {
        Spliterator<Character> spliterator = new WordCountSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        System.out.println("Found " + countWords(stream) + " words");
    }

    private int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }
}
