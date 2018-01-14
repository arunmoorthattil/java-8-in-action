package refactoring.designpatterns.template;

import java.util.function.Consumer;

public class FunctionalOnlineBanking {
    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }
}