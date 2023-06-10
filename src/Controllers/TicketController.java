package Controllers;

import Dto.GenerateTicketRequestDto;
import Models.Ticket;
import Services.TicketService;

public class TicketController {
    TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public Ticket generateTicket(GenerateTicketRequestDto requestDto) {
        Ticket ticket = ticketService.generateTicket(
                requestDto.getVehicleNumber(),
                requestDto.getVehicleType(),
                requestDto.getGateId()
        );
        return ticket;
    }
}
