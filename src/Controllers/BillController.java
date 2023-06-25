package Controllers;

import Models.Bill;
import Models.Ticket;
import Services.BillService;
import enums.PaymentModeEnum;

import java.util.UUID;

public class BillController {
    BillService billService;
    public BillController(BillService billService) {
        this.billService = billService;
    }
    public Bill generateBill(Ticket ticket, PaymentModeEnum paymentMode, UUID operatorId) {
        Bill generatedBill = this.billService.generateBill(ticket, paymentMode, operatorId);
        return generatedBill;
    }
}
