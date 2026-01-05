package elevator.classes;

import java.util.*;

import elevator.enums.Direction;
import elevator.interfaces.ElevatorScheduler;

public class ElevatorManager {
    private Map<Integer, Elevator> elevators = new HashMap<>();
    private ElevatorScheduler scheduler;

    ElevatorManager(ElevatorScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void addNewElevatorInSystem(Elevator elevator) {
        elevators.put(elevator.getId(), elevator);
    }

    public void acceptFloorCallRequest(int floor, Direction direction) {

        List<Elevator> elevatorsList = new ArrayList<>(elevators.values());

        int elevatorId = scheduler.scheduleElevatorOnFloorCallRequest(floor, direction, elevatorsList);

        Elevator selectedElevator = elevators.get(elevatorId);
        
        selectedElevator.processElevatorCallRequest(floor);
    }
}
