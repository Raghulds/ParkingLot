package Services.paymentProviders;

import Models.Transaction;
import interfaces.PaymentGateway;

import java.util.UUID;

public class Razorpay implements PaymentGateway {
    public Transaction pay(Integer amount) {
        return new Transaction(
                UUID.randomUUID(),
                amount,
                "RAZORPAY"
        );
    }
}
