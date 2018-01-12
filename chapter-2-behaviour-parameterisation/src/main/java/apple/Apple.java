package apple;

public class Apple {
    private final String colour;
    private final int weight;

    public Apple(String colour, int weight) {
        this.colour = colour;
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public int getWeight() {
        return weight;
    }
}