package apple.pretty.formatter.impl;

import apple.Apple;
import apple.pretty.formatter.AppleFormatter;

public class AppleWeightBasedFormatter implements AppleFormatter {
    @Override
    public String format(Apple apple) {
        final String heavyOrLight = apple.getWeight() > 150 ? "heavy" : "light";
        final StringBuilder builder = new StringBuilder("A ");
        builder.append(heavyOrLight);
        builder.append(" ");
        builder.append(apple.getColour());
        builder.append(" apple");
        return builder.toString();
    }
}
