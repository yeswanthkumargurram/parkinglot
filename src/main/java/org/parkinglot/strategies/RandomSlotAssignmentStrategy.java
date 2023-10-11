package org.parkinglot.strategies;

import org.parkinglot.models.Gate;
import org.parkinglot.models.ParkingSlot;
import org.parkinglot.models.VehicleType;

public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy{
    @Override
    public ParkingSlot getSlot(Gate gate, VehicleType vehicleType) {
        return null;
    }
}
