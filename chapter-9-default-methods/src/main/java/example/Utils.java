package example;

import java.util.List;

public class Utils {
    public static void paint(List<Resizeable> resizeableShapes) {
        resizeableShapes.forEach(r -> {
            r.setAbsoluteSize(42, 42);;
            r.draw();
        });
    }
}
