package refactoring.designpatterns.strategy;

@FunctionalInterface
public interface ValidationStrategy {
    boolean execute(String s);
}