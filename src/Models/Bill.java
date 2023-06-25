package Models;

import enums.PaymentModeEnum;
import enums.PaymentStatusEnum;

import java.util.UUID;

public class Bill extends BaseModel {
    public UUID ticketId;
    public Integer amount;
    public Float roundOff;
    public UUID operatorId;
    public PaymentStatusEnum paymentStatus;
    public Transaction transaction;
    public PaymentModeEnum paymentMode;

    public Bill() {}
    public Bill(Bill bill) {
        this.paymentMode = bill.paymentMode;
        this.ticketId = bill.ticketId;
        this.amount = bill.amount;
        this.roundOff = bill.roundOff;
        this.operatorId = bill.operatorId;
        this.paymentStatus = PaymentStatusEnum.UNPAID;
    }

    public Float getRoundOff() {
        return roundOff;
    }

    public void setRoundOff(Float roundOff) {
        this.roundOff = roundOff;
    }

    public UUID getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(UUID operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public PaymentStatusEnum getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public PaymentModeEnum getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentModeEnum paymentMode) {
        this.paymentMode = paymentMode;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public void setTicketId(UUID ticketId) {
        this.ticketId = ticketId;
    }
}
