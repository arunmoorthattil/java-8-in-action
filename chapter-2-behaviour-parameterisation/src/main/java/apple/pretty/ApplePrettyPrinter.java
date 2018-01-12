package apple.pretty;

import apple.Apple;
import apple.pretty.formatter.AppleFormatter;

import java.util.List;

public class ApplePrettyPrinter {
    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.format(apple);
            System.out.println(output);
        }
    }
}
