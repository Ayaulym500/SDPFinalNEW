package observer.publisher;

import observer.subscriber.Event;
import observer.subscriber.EventListener;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class EventBus {
    private final List<EventListener> listeners = new CopyOnWriteArrayList<>();

    public void register(EventListener listener) {
        listeners.add(listener);
    }

    public void publish(Event event) {
        for (EventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}
