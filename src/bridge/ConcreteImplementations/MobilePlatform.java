package bridge.ConcreteImplementations;

import bridge.platform.Platform;

public class MobilePlatform implements Platform {
    public void deliver(String content){
        System.out.println("Delivering via Mobile: " + content);
    }
}
