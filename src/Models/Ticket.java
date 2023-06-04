package Models;

import enums.PaymentStatusEnum;

import java.time.LocalTime;
import java.util.List;

public class Ticket extends BaseModel {
    public Vehicle vehicle;
    public Operator operator;
    public LocalTime entryTime = LocalTime.now();
    public ParkingSlot slot;
    public String recipient;
    public ParkingFloor floor;
    public Gate gate;
    public PaymentStatusEnum paymentStatus = PaymentStatusEnum.UNPAID;
    public List<Bill> bills;

    public Ticket() {}
    public Ticket(Ticket ticket) {
        this.vehicle = ticket.vehicle;
        this.operator = ticket.operator;
        this.slot = ticket.slot;
        this.floor = ticket.floor;
        this.gate = ticket.gate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public void setSlot(ParkingSlot slot) {
        this.slot = slot;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public PaymentStatusEnum getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
