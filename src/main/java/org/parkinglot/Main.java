package org.parkinglot;

import org.parkinglot.controller.TicketController;
import org.parkinglot.repository.GateRepository;
import org.parkinglot.repository.ParkingLotRepository;
import org.parkinglot.repository.TicketRepository;
import org.parkinglot.repository.VehicleRepository;
import org.parkinglot.services.TicketService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository
        );

        TicketController ticketController = new TicketController(
                ticketService
        );// all the above things are done by springboot automatically, as we are not using any framework we initialized them
    }
}