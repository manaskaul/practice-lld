package lld_02_elevator.classes;

import java.util.*;

import lld_02_elevator.enums.Direction;
import lld_02_elevator.interfaces.ElevatorScheduler;

public class ElevatorManager {
    
    private Map<Integer, Elevator> elevators = new HashMap<>();
    private ElevatorScheduler scheduler;

    ElevatorManager(ElevatorScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void addNewElevatorInSystem(Elevator elevator) {
        elevators.put(elevator.getId(), elevator);
    }

    public void acceptFloorCallRequest(int callFloor, Direction callDirection) {

        List<Elevator> elevatorsList = new ArrayList<>(elevators.values());

        int elevatorId = scheduler.scheduleElevatorOnFloorCallRequest(callFloor, callDirection, elevatorsList);

        Elevator selectedElevator = elevators.get(elevatorId);
        
        selectedElevator.addPickupStop(callFloor, callDirection);
    }
}
