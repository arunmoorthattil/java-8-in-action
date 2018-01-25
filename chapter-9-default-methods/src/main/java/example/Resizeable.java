package example;

public interface Resizeable extends Drawable {
    int getWidth();
    int getHeight();
    void setWidth(int width);
    void setHeight(int height);
    void setAbsoluteSize(int width, int height);
    // adding the method below would force all the consumers of this interface to
    // implement it, this is not always desirable - especially for libraries
    //void setRelativeSize(int widthFactor, int heightFactor);
    // the alternative is default methods...
    default void setRelativeSize(int widthFactor, int heightFactor) {
        setAbsoluteSize(getWidth() / widthFactor, getHeight() / heightFactor);
    }
}
