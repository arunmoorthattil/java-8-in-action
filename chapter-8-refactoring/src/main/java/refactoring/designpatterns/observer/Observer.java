package refactoring.designpatterns.observer;

@FunctionalInterface
public interface Observer {
    void notify(String tweet);
}