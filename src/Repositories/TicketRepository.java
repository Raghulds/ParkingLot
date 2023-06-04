package Repositories;

import Models.Ticket;

import java.util.HashMap;
import java.util.UUID;

public class TicketRepository {

    HashMap<UUID, Ticket> tickets = new HashMap<UUID, Ticket>();

    public Ticket create(Ticket ticket) {
        tickets.put(ticket.uuid, ticket);
        return ticket;
    }

    public Ticket get(UUID uuid) {
        if(!tickets.containsKey(uuid)) {
            throw new RuntimeException("Ticket with UUID " + uuid + " was not found");
        }
        return tickets.get(uuid);
    }
}
