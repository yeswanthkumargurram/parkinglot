package org.parkinglot.strategies;

import org.parkinglot.models.Gate;
import org.parkinglot.models.ParkingSlot;
import org.parkinglot.models.VehicleType;

public interface SlotAssignmentStrategy {
    public ParkingSlot getSlot(Gate gate, VehicleType vehicleType);

}
