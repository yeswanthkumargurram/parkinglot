package org.parkinglot.controller;

import org.parkinglot.dtos.IssueTicketRequestDto;
import org.parkinglot.dtos.IssueTicketResponseDto;
import org.parkinglot.dtos.ResponseStatus;
import org.parkinglot.exceptions.GateNotFoundException;
import org.parkinglot.models.Ticket;
import org.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
//implemented only issueTicket flow
    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto request){
        IssueTicketResponseDto response = new IssueTicketResponseDto();
        Ticket ticket = null;
        try{
            ticket = ticketService.issueTicket(request.getVehicleType(),
                    request.getVehicleNumber(),
                    request.getVehicleOwnerNumber(),
                    request.getGateId());
        }catch (GateNotFoundException e) {
            response.setResponseStatus(ResponseStatus.ERROR);
            response.setMessage(e.getMessage());
        }
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setTicket(ticket);

        return response;
    }
}
