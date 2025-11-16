package observer.publisher;

import observer.subscriber.Subscriber;

public class Student implements Subscriber {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("[" + name + "] received message: " + message);
    }
}
