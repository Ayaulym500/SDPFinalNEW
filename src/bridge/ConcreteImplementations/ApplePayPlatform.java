package bridge.ConcreteImplementations;

import bridge.platform.Platform;


public class ApplePayPlatform implements Platform {
    public void pay(String content) {
        System.out.println("Processing " + content + " via Apple Pay");
    }
}

