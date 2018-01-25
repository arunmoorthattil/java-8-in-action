package example;

import java.util.List;

import static java.util.Arrays.asList;

public class Game {
    public static void main(String... args) {
        List<Resizeable> resizeableShapes = asList(new Sqaure(), new Rectange(), new Ellipse());
        Utils.paint(resizeableShapes);
    }
}
