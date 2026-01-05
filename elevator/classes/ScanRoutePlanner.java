package elevator.classes;

import java.util.PriorityQueue;

import elevator.enums.Direction;
import elevator.interfaces.RoutePlanner;

public class ScanRoutePlanner implements RoutePlanner {

    private PriorityQueue<Integer> pendingUpwardsFloors;
    private PriorityQueue<Integer> pendingDownwardsFloors;

    @Override
    public void addStop(int currentFloor, int destinationFloor) {
        if (destinationFloor > currentFloor) {
            pendingUpwardsFloors.add(destinationFloor);
        } else if (destinationFloor < currentFloor) {
            pendingDownwardsFloors.add(destinationFloor);
        } else {
            System.out.println("You're already on the floor");
        }
    }

    @Override
    public Integer getNextStop(int currentFloor, Direction moveDirection) {
        if (moveDirection == Direction.MOVING_UP) {
            if (!pendingUpwardsFloors.isEmpty()) {
                return pendingUpwardsFloors.peek();
            }

            if (!pendingDownwardsFloors.isEmpty()) {
                return pendingDownwardsFloors.peek();
            }
        }
        
        if (moveDirection == Direction.MOVING_DOWN) {
            if (!pendingDownwardsFloors.isEmpty()) {
                return pendingDownwardsFloors.peek();
            }

            if (!pendingUpwardsFloors.isEmpty()) {
                return pendingUpwardsFloors.peek();
            }
        }

        return null;
    }
    
}
