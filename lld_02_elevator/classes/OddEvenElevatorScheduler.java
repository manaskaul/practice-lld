package lld_02_elevator.classes;

import java.util.List;

import lld_02_elevator.enums.Direction;
import lld_02_elevator.interfaces.ElevatorScheduler;

public class OddEvenElevatorScheduler implements ElevatorScheduler {
    
    @Override
    public int scheduleElevatorOnFloorCallRequest(int floor, Direction direction, List<Elevator> elevators) {
        return -1;
    }

}
