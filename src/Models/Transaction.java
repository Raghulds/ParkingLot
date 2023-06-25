package Models;

import java.util.UUID;

public class Transaction {
    public UUID transactionId;
    public Integer amountPaid;
    public String paymentGateway;

    public Transaction(UUID transactionId, Integer amountPaid, String paymentGateway) {
        this.transactionId = transactionId;
        this.amountPaid = amountPaid;
        this.paymentGateway = paymentGateway;
    }
}
