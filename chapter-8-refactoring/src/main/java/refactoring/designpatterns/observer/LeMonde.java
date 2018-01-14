package refactoring.designpatterns.observer;

public class LeMonde implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("francais")) {
            System.out.println("Breaking news in Paris... " + tweet);
        }
    }
}