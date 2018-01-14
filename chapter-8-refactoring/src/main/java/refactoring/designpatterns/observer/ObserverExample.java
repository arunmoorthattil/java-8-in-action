package refactoring.designpatterns.observer;

public class ObserverExample {
    public void example() {
        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
        feed.registerObserver(new LeMonde());
        feed.notifyObservers("The prime minister said her favourite book is Java 8 in Action!");
    }
}
