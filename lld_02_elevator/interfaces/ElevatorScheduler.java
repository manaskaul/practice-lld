package lld_02_elevator.interfaces;

import java.util.List;

import lld_02_elevator.classes.Elevator;
import lld_02_elevator.enums.Direction;

public interface ElevatorScheduler {
    
    public int scheduleElevatorOnFloorCallRequest(int callFloor, Direction callDirection, List<Elevator> elevators);
    
}
