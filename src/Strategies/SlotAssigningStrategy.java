package Strategies;

import Models.ParkingFloor;
import Models.ParkingSlot;
import Repositories.ParkingLotRepository;
import enums.SlotAvailabilityEnum;
import enums.VehicleTypeEnum;
import interfaces.SlotAssigning;

import java.util.List;

public class SlotAssigningStrategy implements SlotAssigning {
    ParkingLotRepository parkingLotRepository;
    public SlotAssigningStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingSlot assignSlot(VehicleTypeEnum vehicleType) throws RuntimeException {
        List<ParkingFloor> floors = this.parkingLotRepository.lot.getFloors();
        for(ParkingFloor floor: floors) {
            List<ParkingSlot> slots = floor.getSlots();
            for(ParkingSlot slot: slots) {
                if(slot.getStatus().equals(SlotAvailabilityEnum.FREE) &&
                                slot.getVehicleStorageType().equals(vehicleType)) {
                    return slot;
                }
            }
        }
        throw new RuntimeException("No slots available");
    }
}
