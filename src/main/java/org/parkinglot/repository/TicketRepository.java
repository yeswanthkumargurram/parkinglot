package org.parkinglot.repository;

import org.parkinglot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    Map<Long, Ticket> ticketMap = new HashMap<>();
    int id =0;
    public Ticket saveTicket(Ticket ticket){
        id += 1;
        ticket.setId((long)id);
        ticketMap.put((long)id, ticket);
        return ticket;//the returned ticket will have id but the input parameter ticket object won't have it.
    }
}
