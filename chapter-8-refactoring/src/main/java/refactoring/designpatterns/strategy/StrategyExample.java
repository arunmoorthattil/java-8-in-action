package refactoring.designpatterns.strategy;

public class StrategyExample {
    public void example() {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllInLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");
    }
}
