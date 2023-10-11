package org.parkinglot.repository;

import org.parkinglot.models.Gate;
import org.parkinglot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    Map<Long, ParkingLot> parkingLots = new HashMap<>();
    public ParkingLot getParkingLotForGate(Gate gate){
       for(ParkingLot lot : parkingLots.values()){
           if(lot.getGates().contains(gate)){
               return lot;
           }
       }
       return null;
    }
}
