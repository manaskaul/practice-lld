package elevator.classes;

import java.util.List;

import elevator.enums.Direction;
import elevator.interfaces.ElevatorScheduler;

public class OddEvenElevatorScheduler implements ElevatorScheduler {
    
    @Override
    public int scheduleElevatorOnFloorCallRequest(int floor, Direction direction, List<Elevator> elevators) {
        return -1;
    }

}
