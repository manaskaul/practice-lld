package elevator.classes;

import java.util.Comparator;
import java.util.PriorityQueue;

import elevator.enums.Direction;
import elevator.interfaces.RoutePlanner;

public class ScanRoutePlanner implements RoutePlanner {

    // Destinations (passengers inside)
    PriorityQueue<Integer> upDestinations;    // min heap
    PriorityQueue<Integer> downDestinations;  // max heap

    // Pickups (passengers waiting)
    PriorityQueue<Integer> upPickups;          // min heap
    PriorityQueue<Integer> downPickups;        // max heap

    ScanRoutePlanner() {
        this.upDestinations = new PriorityQueue<>(Comparator.naturalOrder());
        this.downDestinations = new PriorityQueue<>(Comparator.reverseOrder());

        this.upPickups = new PriorityQueue<>(Comparator.naturalOrder());
        this.downPickups = new PriorityQueue<>(Comparator.reverseOrder());
    }

/*
    // A simpler implementation where direction of the floor doesn't matter
    // Pickup and Destination floors are treated similarly
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
*/

    @Override
    public void addPickupStop(int currentFloor, int pickupFloor, Direction callDirection) {
        if (callDirection == Direction.MOVING_UP) {
            if (pickupFloor > currentFloor) {
                upPickups.add(pickupFloor);      // serve in UP phase
            } else {
                // below current floor → defer until next UP cycle
                downPickups.add(pickupFloor);
            }
        } else {
            if (pickupFloor < currentFloor) {
                downPickups.add(pickupFloor);    // serve in DOWN phase
            } else {
                // above current floor → defer
                upPickups.add(pickupFloor);
            }
        }
    }

    @Override
    public void addDestinationStop(int currentFloor, int destinationFloor) {
        if (destinationFloor > currentFloor) {
            upDestinations.add(destinationFloor);
        } else if (destinationFloor < currentFloor) {
            downDestinations.add(destinationFloor);
        } else {
            System.out.println("You're already on the floor");
        }
    }

    @Override
    public Integer getNextStop(int currentFloor, Direction moveDirection) {
        if (moveDirection == Direction.MOVING_UP) {

            // 1. Serve destinations first
            if (!upDestinations.isEmpty()) {
                return upDestinations.peek();
            }

            // 2. Then serve UP pickups
            if (!upPickups.isEmpty()) {
                return upPickups.peek();
            }

            // 3. Nothing left going up → reverse
            if (!downDestinations.isEmpty()) {
                return downDestinations.peek();
            }
            if (!downPickups.isEmpty()) {
                return downPickups.peek();
            }
        }

        if (moveDirection == Direction.MOVING_DOWN) {

            // 1. Serve destinations first
            if (!downDestinations.isEmpty()) {
                return downDestinations.peek();
            }

            // 2. Then serve DOWN pickups
            if (!downPickups.isEmpty()) {
                return downPickups.peek();
            }

            // 3. Nothing left going down → reverse
            if (!upDestinations.isEmpty()) {
                return upDestinations.peek();
            }
            if (!upPickups.isEmpty()) {
                return upPickups.peek();
            }
        }

        // IDLE case
        if (!upDestinations.isEmpty()) return upDestinations.peek();
        if (!upPickups.isEmpty()) return upPickups.peek();
        if (!downDestinations.isEmpty()) return downDestinations.peek();
        if (!downPickups.isEmpty()) return downPickups.peek();

        return null;
    }

    @Override
    public void onStopServiced(int currentFloor) {
        upDestinations.remove(currentFloor);
        downDestinations.remove(currentFloor);
        upPickups.remove(currentFloor);
        downPickups.remove(currentFloor);
    }
    
}
