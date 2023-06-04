package Models;

import enums.FloorStatusEnum;

import java.util.List;

public class ParkingFloor extends BaseModel {
    public Integer number;
    public List<ParkingSlot> slots;
    public FloorStatusEnum status;

    public ParkingFloor() {}
    public ParkingFloor(ParkingFloor floor) {
        this.number = floor.number;
        this.status = floor.status;
        this.slots = floor.slots;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public void setSlots(List<ParkingSlot> slots) {
        this.slots = slots;
    }

    public FloorStatusEnum getStatus() {
        return status;
    }

    public void setStatus(FloorStatusEnum status) {
        this.status = status;
    }
}
