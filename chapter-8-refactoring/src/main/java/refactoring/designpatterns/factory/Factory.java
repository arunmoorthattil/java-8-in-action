package refactoring.designpatterns.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Factory {
    private final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduce(String productName) {
        Supplier<Product> p = map.get(productName);
        if (p != null) {
            return p.get();
        } else {
            throw new IllegalArgumentException("No such product: " + productName);
        }
    }
}
