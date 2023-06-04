package Services;

import Models.Gate;
import Models.ParkingSlot;
import Models.Ticket;
import Models.Vehicle;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehiclesRepository;
import Strategies.SlotAssigningStrategy;
import enums.VehicleTypeEnum;

import java.util.UUID;

public class TicketService {

    VehicleService vehicleService;
    SlotAssigningStrategy slotAssigningStrategy;
    ParkingLotRepository parkingLotRepository;
    TicketRepository ticketRepository;

    public TicketService(
            VehicleService vehicleService,
            SlotAssigningStrategy slotAssigningStrategy,
            ParkingLotRepository parkingLotRepository,
            TicketRepository ticketRepository
    ) {
        this.vehicleService = vehicleService;
        this.slotAssigningStrategy = slotAssigningStrategy;
        this.parkingLotRepository = parkingLotRepository;
    }
    public Ticket generateTicket(String vehicleNumber, VehicleTypeEnum vehicleType, UUID gateId) {
        Ticket ticket = new Ticket();
        Gate gate = parkingLotRepository.getGateById(gateId);
        ticket.setGate(gate);
        // Check for the vehicle existence
        Vehicle vehicle = vehicleService.getVehicleByNumber(vehicleNumber);
        // If not found, add vehicle
        if(vehicle == null) {
            Vehicle vehicleObject = new Vehicle();
            vehicleObject.setNumber(vehicleNumber);
            vehicleObject.setModel(vehicleType);
            vehicleService.create(vehicleObject);
        }
        ticket.setVehicle(vehicle);
        // Assign a spot
        ParkingSlot slot = slotAssigningStrategy.assignSlot(vehicleType);
        ticket.setSlot(slot);
        // Save the ticket
        ticketRepository.create(ticket);
        return ticket;
    }

}
