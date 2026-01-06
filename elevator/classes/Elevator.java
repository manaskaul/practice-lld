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
    private Direction movingDirection;
    private State elevatorState;

/*
    // Elevator can itself have the route planning and the next floor check
    // but this can also be done with the RoutePlanner
    private PriorityQueue<Integer> pendingUpwardsFloors;    // min heap
    private PriorityQueue<Integer> pendingDownwardsFloors;  // max heap
*/

    private RoutePlanner routePlanner;

    Elevator(int id, RoutePlanner planner) {
        this.id = id;
        this.currentFloor = 0;
        this.movingDirection = null;
        this.elevatorState = State.IDLE;
        
        this.routePlanner = planner;
    }

    Elevator() {
        Random r = new Random();
        
        this.id = r.nextInt(100, 1000);
        this.currentFloor = 0;
        this.movingDirection = null;
        this.elevatorState = State.IDLE;
        this.routePlanner = new ScanRoutePlanner();
    }

    public void addPickupStop(int pickupFloor, Direction callDirection) {
        // Only decide direction if elevator is idle
        if (elevatorState == State.IDLE) {
            if (pickupFloor > currentFloor) {
                movingDirection = Direction.MOVING_UP;
            } else if (pickupFloor < currentFloor) {
                movingDirection = Direction.MOVING_DOWN;
            }
            elevatorState = State.MOVING;
        }

        routePlanner.addPickupStop(currentFloor, pickupFloor, callDirection);
    }

    public void addDestinationStop(int destinationFloor) {
        if (elevatorState == State.IDLE) {
            if (destinationFloor > currentFloor) {
                movingDirection = Direction.MOVING_UP;
            } else if (destinationFloor < currentFloor) {
                movingDirection = Direction.MOVING_DOWN;
            }
            elevatorState = State.MOVING;
        }

        routePlanner.addDestinationStop(currentFloor, destinationFloor);
    }

    // A tick event that checks the current floor
    // and is resonsible for changing direction or staying idle
    public void tick() {
        Integer nextStop = routePlanner.getNextStop(currentFloor, movingDirection);

        if (nextStop == null) {
            elevatorState = State.IDLE;
            movingDirection = null;
            return;
        }

        // Arrived at stop
        if (currentFloor == nextStop) {
            routePlanner.onStopServiced(nextStop);
            return;
        }

        elevatorState = State.MOVING;

        // Move one floor
        if (currentFloor < nextStop) {
            currentFloor++;
            movingDirection = Direction.MOVING_UP;
        } else {
            currentFloor--;
            movingDirection = Direction.MOVING_DOWN;
        }
    }



/*
    // Simple add floor to queue for it to be serviced
    // This has now been moved to the RoutePlanner
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
    
/*
    // Called by ElevatorManager when the Call Button is pressed
    // This will be called after scheduler decides this elevator needs to server the call request
    // This has now been updated to handle the destination and pickup request seperately in route planner
    public void addPickupStop(int floor) {
        // If elevator is idle, decide initial direction
        if (elevatorState == State.IDLE) {
            if (floor > currentFloor) {
                currentMovingDirection = Direction.MOVING_UP;
            } else if (floor < currentFloor) {
                currentMovingDirection = Direction.MOVING_DOWN;
            }
            elevatorState = State.MOVING;
        }

        routePlanner.addStop(currentFloor, floor);
    }
*/

/*
    // Called from inside the elevator
    // This has now been updated to handle the destination and pickup request seperately in route planner
    public void addDestinationStop(int floor) {
        // Same logic applies for internal car requests
        if (elevatorState == State.IDLE) {
            if (floor > currentFloor) {
                currentMovingDirection = Direction.MOVING_UP;
            } else if (floor < currentFloor) {
                currentMovingDirection = Direction.MOVING_DOWN;
            }
            elevatorState = State.MOVING;
        }
        
        routePlanner.addStop(currentFloor, floor);
    }
*/
    
}
