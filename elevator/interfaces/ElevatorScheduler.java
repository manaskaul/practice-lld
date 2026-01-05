package elevator.interfaces;

import java.util.List;

import elevator.classes.Elevator;
import elevator.enums.Direction;

public interface ElevatorScheduler {
    
    public int scheduleElevatorOnFloorCallRequest(int floor, Direction direction, List<Elevator> elevators);
    
}
