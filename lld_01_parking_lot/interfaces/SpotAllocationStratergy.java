package lld_01_parking_lot.interfaces;

import java.util.List;

import lld_01_parking_lot.classes.ParkingFloor;
import lld_01_parking_lot.classes.ParkingSpot;
import lld_01_parking_lot.classes.Vehicle;

public interface SpotAllocationStratergy {
    ParkingSpot allocateSpot(Vehicle vehicle, List<ParkingFloor> floors);
}
