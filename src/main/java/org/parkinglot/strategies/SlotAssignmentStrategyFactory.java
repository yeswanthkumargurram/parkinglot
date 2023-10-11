package org.parkinglot.strategies;

import org.parkinglot.models.SlotAllotmentStrategyType;

public class SlotAssignmentStrategyFactory {
    public static SlotAssignmentStrategy getSlotForType(SlotAllotmentStrategyType slotAssignmentStrategyType){
            return new RandomSlotAssignmentStrategy();
    }
}
