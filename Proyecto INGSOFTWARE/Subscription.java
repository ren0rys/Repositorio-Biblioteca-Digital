import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String message);
}

class Subscription {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}





