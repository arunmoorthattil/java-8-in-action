package refactoring.designpatterns.template;

public class TemplateExample {
    public void example() {
        FunctionalOnlineBanking onlineBanking = new FunctionalOnlineBanking();
        onlineBanking.processCustomer(1337, (Customer c) ->
                System.out.println("Hello " + c.getName()));
    }
}