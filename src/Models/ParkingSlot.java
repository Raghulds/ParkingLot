package Models;

import enums.SlotAvailabilityEnum;
import enums.VehicleTypeEnum;

public class ParkingSlot extends BaseModel {
    public ParkingFloor floor;
    public SlotAvailabilityEnum status;
    public VehicleTypeEnum vehicleStorageType;

    public ParkingSlot() {}
    public ParkingSlot(ParkingSlot slot) {
        this.floor = slot.floor;
        this.status = slot.status;
        this.vehicleStorageType = slot.vehicleStorageType;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public SlotAvailabilityEnum getStatus() {
        return status;
    }

    public void setStatus(SlotAvailabilityEnum status) {
        this.status = status;
    }

    public VehicleTypeEnum getVehicleStorageType() {
        return vehicleStorageType;
    }

    public void setVehicleStorageType(VehicleTypeEnum vehicleStorageType) {
        this.vehicleStorageType = vehicleStorageType;
    }
}
