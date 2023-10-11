package org.parkinglot.repository;

import org.parkinglot.models.Gate;

import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

public class GateRepository {
    Map<Long, Gate> gates = new HashMap<>();
    public Optional<Gate> findGateById(Long gateId){
        if(gates.containsKey(gateId)){
            return Optional.of(gates.get(gateId));
        }
        return Optional.empty();
    }
}
