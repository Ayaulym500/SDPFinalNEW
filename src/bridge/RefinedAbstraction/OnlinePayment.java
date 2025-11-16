package bridge.RefinedAbstraction;

import bridge.abstraction.PaymentContent;
import bridge.platform.Platform;


public class OnlinePayment extends PaymentContent {
    public OnlinePayment(Platform platform) {
        super(platform);
    }

    @Override
    public void processPayment() {
        platform.pay("Online Payment");
    }
}

