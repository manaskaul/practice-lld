package elevator.interfaces;

import elevator.enums.Direction;

public interface RoutePlanner {
    
    // This would be called to serve the floor call request
    // The route planner should be aware of -
    // current elevator floor, floor where the call is made, and dirrection user want to go towards
    public void addPickupStop(int currentFloor, int pickupFloor, Direction callDirection);

    // This would be called to serve the internal elevator car request
    // The route planner should be aware of -
    // current elevator floor, the floor where the user want to go to
    public void addDestinationStop(int currentFloor, int destinationFloor);

    public Integer getNextStop(int currentFloor, Direction moveDirection);

    public void onStopServiced(int nextStop);

}
