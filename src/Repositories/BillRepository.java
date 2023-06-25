package Repositories;

import Models.Bill;

import java.util.ArrayList;
import java.util.List;

public class BillRepository {
    List<Bill> bills = new ArrayList<Bill>();

    public List<Bill> getBills() {
        return bills;
    }

    public void addBill(Bill bill) {
        this.bills.add(bill);
    }

    public Bill getBillByTicketId(String ticketId) {
        for(Bill each:bills) {
            if(each.ticketId == ticketId) {
                return each;
            }
        }
        return null;
    }
}
