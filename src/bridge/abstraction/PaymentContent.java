package bridge.abstraction;

import bridge.platform.Platform;


public abstract class PaymentContent {
    protected Platform platform;
    public PaymentContent(Platform platform) {
        this.platform = platform;
    }
    public abstract void processPayment();
}

