package Services;

import Models.Bill;
import Models.Ticket;
import Models.Transaction;
import enums.PaymentModeEnum;
import enums.PaymentStatusEnum;

import java.util.UUID;

public class BillService {
    public Bill generateBill(Ticket ticket, PaymentModeEnum paymentMode, UUID operatorId) {
        Bill bill = new Bill();
        // Calculate total amount based on vehicle, parking duration (Strategy pattern)
        Float amount = 190.6F;
        Integer rounded = Math.round(amount);
        bill.setAmount(rounded);
        bill.setPaymentMode(paymentMode);
        bill.setPaymentStatus(PaymentStatusEnum.UNPAID);
        bill.setOperatorId(operatorId);
        bill.setTicketId(ticket.getUuid());
        bill.setRoundOff(amount - rounded);
        return bill;
    }

    public Transaction payBill(Integer amount, PaymentModeEnum mode) {
        return null;
    }
}
