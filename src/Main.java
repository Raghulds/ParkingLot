import Controllers.BillController;
import Controllers.TicketController;
import Dto.GenerateTicketRequestDto;
import Models.Bill;
import Models.Gate;
import Models.Ticket;
import Models.Transaction;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehiclesRepository;
import Services.BillService;
import Services.TicketService;
import Services.VehicleService;
import Strategies.SlotAssigningStrategy;
import enums.PaymentModeEnum;
import enums.VehicleTypeEnum;

import java.util.Scanner;
import java.util.UUID;

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
        BillService billService = new BillService();

        Scanner inStream = new Scanner(System.in);
        actionPrompt();
        Integer actionNumber = inStream.nextInt();
        while(actionNumber != 1 || actionNumber != 2) {
            if(actionNumber == 1) {
                Ticket generatedTicket = generateTicket(inStream, lot, ticketService);
                System.out.println("Ticket generated: " + generatedTicket.getUuid());
                System.out.println("Safe parking :)");
            } else if(actionNumber == 2) {
                paymentModePrompt();
                Integer modeNumber = inStream.nextInt();
                while(modeNumber != 1 && modeNumber != 2) {
                    paymentModePrompt();
                }
                PaymentModeEnum paymentMode;
                if(modeNumber == 1) {
                    paymentMode = PaymentModeEnum.ONLINE;
                } else {
                    paymentMode = PaymentModeEnum.CASH;
                }
                Bill generatedBill = generateBill(inStream, billService, ticketRepository, paymentMode, UUID.fromString("werty"));
                System.out.println("Bill was generated! Amount to be paid: " + generatedBill.getAmount());
            } else if(actionNumber == 3) {
                System.out.println("Always welcome :)");
            } else if(actionNumber == 4) break;
            actionPrompt();
            actionNumber = inStream.nextInt();
        }
    }

    private static void actionPrompt() {
        System.out.println("Enter the action number: ");
        System.out.println("[1] Generate ticket");
        System.out.println("[2] Generate bill");
        System.out.println("[3] Pay bill");
        System.out.println("[4] Exit app");
        System.out.println("---------------------------------");
    }

    private static void paymentModePrompt() {
        System.out.println("Enter the payment mode: ");
        System.out.println("[1] Online");
        System.out.println("[2] Cash");
        System.out.println("[3] Cancel");
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

    private static Bill generateBill(Scanner inStream, BillService billService, TicketRepository ticketRepository, PaymentModeEnum paymentMode, UUID operatorId) throws RuntimeException {
        System.out.println("Enter the ticket ID");
        String ticketIdString = inStream.next();
        // Check if ticket is valid
        Ticket ticket = ticketRepository.getTicketById(UUID.fromString(ticketIdString));
        if(ticket == null) {
            throw new RuntimeException("Ticket was not found! Enter a valid ticket number");
        }
        // generate bill
        BillController billController = new BillController(billService);
        Bill bill = billController.generateBill(ticket, paymentMode, operatorId);
        return bill;
    }

    private static Transaction payBill(Scanner inStream, BillService billService, Bill bill) {
        return null;
    }
}