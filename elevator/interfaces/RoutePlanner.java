package elevator.interfaces;

import elevator.enums.Direction;

public interface RoutePlanner {
    
    public void addStop(int currentFloor, int destinationFloor);
    public Integer getNextStop(int currentFloor, Direction moveDirection);

}
