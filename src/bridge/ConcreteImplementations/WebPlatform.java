package bridge.ConcreteImplementations;

import bridge.platform.Platform;

public class WebPlatform implements Platform {
    public void deliver(String content){ System.out.println("Delivering via Web: " + content);
    }
}
