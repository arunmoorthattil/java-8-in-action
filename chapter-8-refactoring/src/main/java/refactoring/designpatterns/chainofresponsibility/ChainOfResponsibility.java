package refactoring.designpatterns.chainofresponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponsibility {
    public void example() {
        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellingCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellingCheckerProcessing);

        String result = pipeline.apply("Aren't labdas really sexy?!!");
    }
}
