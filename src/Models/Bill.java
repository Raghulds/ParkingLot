package Models;

import enums.PaymentModeEnum;

public class Bill extends BaseModel {
    public String transactionId;
    public Integer paidAmount;
    public PaymentModeEnum paymentMode;

    public Bill(Bill bill) {
        this.paidAmount = bill.paidAmount;
        this.transactionId = bill.transactionId;
        this.paymentMode = bill.paymentMode;
    }
}
