package interfaces;

import Models.Transaction;

public interface PaymentGateway {

    public Transaction pay(Integer amount);
}
