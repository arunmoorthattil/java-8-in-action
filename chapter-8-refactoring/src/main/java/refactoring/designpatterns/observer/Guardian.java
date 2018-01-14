package refactoring.designpatterns.observer;

public class Guardian implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("prime minister")) {
            System.out.println("Breaking news in London... " + tweet);
        }
    }
}