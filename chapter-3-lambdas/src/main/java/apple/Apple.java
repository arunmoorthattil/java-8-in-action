package apple;

public class Apple {
    private final String colour;
    private final Integer weight;

    public Apple(String colour, Integer weight) {
        this.colour = colour;
        this.weight = weight;
    }

    public Apple(Integer weight) {
        this.weight = weight;
        this.colour = null;
    }

    public String getColour() {
        return colour;
    }

    public Integer getWeight() {
        return weight;
    }
}