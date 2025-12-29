package parking_lot.interfaces;

import java.util.List;

import parking_lot.classes.ParkingFloor;
import parking_lot.classes.ParkingSpot;
import parking_lot.classes.Vehicle;

public interface SpotAllocationStratergy {
    ParkingSpot allocateSpot(Vehicle vehicle, List<ParkingFloor> floors);
}
