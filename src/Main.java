import Controllers.TicketController;
import Dto.GenerateTicketRequestDto;
import Models.Bill;
import Models.Gate;
import Models.Ticket;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehiclesRepository;
import Services.TicketService;
import Services.VehicleService;
import Strategies.SlotAssigningStrategy;
import enums.VehicleTypeEnum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lot setup
        ParkingLotRepository lot = new ParkingLotRepository();
        VehiclesRepository vehiclesRepository = new VehiclesRepository();
        VehicleService vehicleService = new VehicleService(vehiclesRepository);
        SlotAssigningStrategy slotAssigningStrategy = new SlotAssigningStrategy(lot);
        TicketRepository ticketRepository = new TicketRepository();
        TicketService ticketService = new TicketService(
                vehicleService,
                slotAssigningStrategy,
                lot,
                ticketRepository
        );

        Scanner inStream = new Scanner(System.in);
        actionPrompt();
        Integer actionNumber = inStream.nextInt();
        while(actionNumber != 1 || actionNumber != 2) {
            if(actionNumber == 1) {
                Ticket generatedTicket = generateTicket(inStream, lot, ticketService);
                System.out.println("Ticket generated: " + generatedTicket.getUuid());
                System.out.println("Safe parking :)");
            } else if(actionNumber == 2) {
                Bill generatedBill = payBill();
                System.out.println("Bill with " + generatedBill.transactionId + " was paid!");
                System.out.println("Always welcome :)");
            } else if(actionNumber == 3) break;
            actionPrompt();
            actionNumber = inStream.nextInt();
        }
    }

    private static void actionPrompt() {
        System.out.println("Enter the action number: ");
        System.out.println("[1] Generate ticket");
        System.out.println("[2] Pay bill");
        System.out.println("[3] Exit app");
        System.out.println("---------------------------------");
    }

    private static Ticket generateTicket(Scanner inStream, ParkingLotRepository lot, TicketService ticketService) {

        System.out.println("Enter the vehicle number");
        String vehicleNumber = inStream.next();

        System.out.println("Enter the vehicle type. Below are the allowed vehicle types");
        VehicleTypeEnum.stream().forEach(System.out::println);
        String vehicleType = inStream.next();
        while(VehicleTypeEnum.findByName(vehicleType) == null) {
            System.out.println("Enter the valid vehicle type. Below are the allowed vehicle types");
            VehicleTypeEnum.stream().forEach(System.out::println);
            vehicleType = inStream.next();
        }

        System.out.println("Enter the gate no");
        Integer gateNumber = inStream.nextInt();
        Gate gate = lot.getGateByNumber(gateNumber);
        while(gate == null) {
            System.out.println("Not a valid gate number.");
            System.out.println("Enter the correct gate no");
            gateNumber = inStream.nextInt();
            gate = lot.getGateByNumber(gateNumber);
        }

        GenerateTicketRequestDto requestObject = new GenerateTicketRequestDto();
        requestObject.setGateId(gate.getUuid());
        requestObject.setVehicleNumber(vehicleNumber);
        requestObject.setVehicleType(VehicleTypeEnum.valueOf(vehicleType));

        TicketController controller = new TicketController(ticketService);
        return controller.generateTicket(requestObject);
    }

    private static Bill payBill() {
        System.out.println("Enter the ticket ID");
        // Check if ticket is valid
        // get payment mode
        // generate bill after payment successful
        return new Bill();
    }
}