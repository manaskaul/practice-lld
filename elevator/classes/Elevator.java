package elevator.classes;

import java.util.*;

import elevator.enums.Direction;
import elevator.enums.State;
import elevator.interfaces.RoutePlanner;
import lombok.Getter;

@Getter
public class Elevator {
    private int id;
    private int currentFloor;
    private Direction currentMovingDirection;
    private State elevatorState;

/*
    // Elevator can itself have the route planning and the next floor check
    // but this can also be done with the RoutePlanner
    private PriorityQueue<Integer> pendingUpwardsFloors;
    private PriorityQueue<Integer> pendingDownwardsFloors;
*/

    private RoutePlanner routePlanner;

    Elevator(int id, RoutePlanner planner) {
        this.id = id;
        this.currentFloor = 0;
        this.currentMovingDirection = null;
        this.elevatorState = State.IDLE;
/*
        // min queue
        this.pendingUpwardsFloors = new PriorityQueue<>(Comparator.naturalOrder());
        // max queue
        this.pendingDownwardsFloors = new PriorityQueue<>(Comparator.reverseOrder());
*/
        this.routePlanner = planner;
    }

    Elevator() {
        Random r = new Random();
        
        this.id = r.nextInt(100, 1000);
        this.currentFloor = 0;
        this.currentMovingDirection = null;
        this.elevatorState = State.IDLE;
        this.routePlanner = new ScanRoutePlanner();
    }

/*
    private void addFloorToQueue(int floorNum) {
        if (floorNum > currentFloor) {
            pendingUpwardsFloors.add(floorNum);
        } else if (floorNum < currentFloor) {
            pendingDownwardsFloors.add(floorNum);
        } else {
            System.out.println("You're already on the floor");
        }
    }
*/
    
    // Called by ElevatorManager when the Call Button is pressed
    // This will be called after scheduler decides this elevator needs to server the call request
    public void processElevatorCallRequest(int floor) {
        routePlanner.addStop(currentFloor, floor);
    }

    // Called from inside the elevator
    public void processElevatorCarRequest(int floor) {
        routePlanner.addStop(currentFloor, floor);
    }

    // A tick event that checks the current floor
    // and is resonsible for changing direction or staying idle
    public Integer tick() {
        return routePlanner.getNextStop(currentFloor, currentMovingDirection);
    }
}
