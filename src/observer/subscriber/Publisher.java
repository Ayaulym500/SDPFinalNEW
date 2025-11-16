package observer.subscriber;


import java.util.concurrent.Flow;

public interface Publisher {
    void register(Subscriber subscriber);
    void unregister(Subscriber subscriber);
    void notifySubscribers(String message);
}
