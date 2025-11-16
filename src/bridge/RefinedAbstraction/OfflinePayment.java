package bridge.RefinedAbstraction;

import bridge.abstraction.PaymentContent;
import bridge.platform.Platform;



public class OfflinePayment extends PaymentContent {
    public OfflinePayment(Platform platform) {
        super(platform);
    }

    @Override
    public void processPayment() {
        platform.pay("Offline Payment");
    }
}


