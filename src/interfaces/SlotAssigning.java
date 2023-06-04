package interfaces;

import Models.ParkingSlot;
import enums.VehicleTypeEnum;

public interface SlotAssigning {
    public ParkingSlot assignSlot(VehicleTypeEnum vehicleType);
}
