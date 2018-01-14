package refactoring.designpatterns.strategy;

public class IsAllInLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a+z]+");
    }
}