package org.parkinglot.services;

import org.parkinglot.exceptions.GateNotFoundException;
import org.parkinglot.models.*;
import org.parkinglot.repository.GateRepository;
import org.parkinglot.repository.ParkingLotRepository;
import org.parkinglot.repository.TicketRepository;
import org.parkinglot.repository.VehicleRepository;
import org.parkinglot.strategies.SlotAssignmentStrategy;
import org.parkinglot.strategies.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    public GateRepository gateRepository;
    public VehicleRepository vehicleRepository;
    public ParkingLotRepository parkingLotRepository;
    public TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(VehicleType vehicleType, String vehicleNumber,
                              String vehicleOwnerName, Long gateId) throws GateNotFoundException {
        //create ticket obj
        //assign parking slot
        //assign time
        //save to dd
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        //get GATE from gateId
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(!gateOptional.isPresent()){
            throw new GateNotFoundException();
        }
        Gate gate = gateOptional.get();
        ticket.setGate(gate);
        ticket.setGeneratedBy(gate.getOperator());

        Vehicle savedVehicle;
        Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleById(vehicleNumber);
        if(optionalVehicle.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setNumber(vehicleNumber);
            vehicle.setOwnerName(vehicleOwnerName);
            savedVehicle = vehicleRepository.saveVehicle(vehicle);

        }else{
            savedVehicle = optionalVehicle.get();

        }
        ticket.setVehicle(savedVehicle);
        SlotAllotmentStrategyType slotAllotmentStrategyType =
                parkingLotRepository.getParkingLotForGate(gate).getSlotAllotmentStrategyType();
        SlotAssignmentStrategy slotAssignmentStrategy =
                SlotAssignmentStrategyFactory.getSlotForType(
                        slotAllotmentStrategyType);
        ticket.setParkingSlot(slotAssignmentStrategy.getSlot(gate, vehicleType));
        ticket.setTicketNumber("Ticket-"+ticket.getId());//some random number as of now
        ticketRepository.saveTicket(ticket);
        return ticket;
    }
}
