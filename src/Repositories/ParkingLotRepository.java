package Repositories;

import Models.Gate;
import Models.ParkingFloor;
import Models.ParkingLot;
import Models.ParkingSlot;
import enums.FloorStatusEnum;
import enums.GateTypeEnum;
import enums.SlotAvailabilityEnum;
import enums.VehicleTypeEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ParkingLotRepository {
    public ParkingLot lot = new ParkingLot();
    public List<ParkingFloor> floors = new ArrayList<ParkingFloor>();
    public ParkingLotRepository() {

        lot.setCity("Bangalore");
        lot.setName("Lot 1");
        List<Gate> gates = new ArrayList<Gate>();
        // Entry gate
        Gate gate = new Gate();
        gate.setType(GateTypeEnum.ENTRY);
        gate.setNumber(1);
        gates.add(gate);
        // Exit gate
        Gate gate2 = new Gate();
        gate2.setType(GateTypeEnum.EXIT);
        gate.setNumber(1);
        gates.add(gate2);
        lot.setGates(gates);
        // Default: 5 floors - 0 Vehicles
        // Default: 100 active slots each floor
        // Default: Even number slots are two-wheeler storage type & Odd number slots are four-wheeler storage type
        Integer[] defaultFloors = {1, 2, 3, 4, 5};
        Integer[] defaultSlots = new Integer[100];
        Arrays.setAll(defaultSlots, i -> i + 1);
        for(int floor: defaultFloors) {
            ParkingFloor parkingFloor = new ParkingFloor();
            List<ParkingSlot> allSlots = new ArrayList<ParkingSlot>();
            parkingFloor.setNumber(floor);
            parkingFloor.setStatus(FloorStatusEnum.ACTIVE);
            for(int slot: defaultSlots) {
                ParkingSlot parkingSlot = new ParkingSlot();
                parkingSlot.setFloor(parkingFloor);
                parkingSlot.setStatus(SlotAvailabilityEnum.FREE);
                if(slot%2 == 0) {
                    parkingSlot.setVehicleStorageType(VehicleTypeEnum.TWO_WHEELER);
                } else {
                    parkingSlot.setVehicleStorageType(VehicleTypeEnum.LIGHT_FOUR_WHEELER);
                }
                allSlots.add(parkingSlot);
            }
            parkingFloor.setSlots(allSlots);
            floors.add(parkingFloor);
        }
        lot.setFloors(floors);
    }

    public Gate getGateById(UUID gateId) {
        List<Gate> gates = lot.getGates();
        for (Gate gate:gates) {
            if(gate.getUuid().equals(gateId)) {
                return gate;
            }
        }
        return null;
    }

    public Gate getGateByNumber(Integer number) {
        List<Gate> gates = lot.getGates();
        for (Gate gate:gates) {
            if(gate.getNumber() != null && gate.getNumber().equals(number)) {
                return gate;
            }
        }
        return null;
    }
}
