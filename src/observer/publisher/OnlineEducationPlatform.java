package observer.publisher;

import observer.subscriber.Publisher;
import observer.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;



public class OnlineEducationPlatform implements Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void register(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unregister(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String message) {
        for (Subscriber s : subscribers) {
            s.update(message);
        }
    }

    public void newWebinar(String topic) {
        notifySubscribers("New webinar: " + topic);
    }

    public void promotion(String details) {
        notifySubscribers("Promotion: " + details);
    }
}
