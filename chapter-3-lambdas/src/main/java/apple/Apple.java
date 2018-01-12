package apple;

public class Apple {
    private final String colour;
    private final Integer weight;

    public Apple(String colour, int weight) {
        this.colour = colour;
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public Integer getWeight() {
        return weight;
    }
}