package parking_lot.classes;

import lombok.Getter;
import lombok.Setter;

import parking_lot.enums.VehicleType;

@Getter
@Setter
public class ParkingSpot {
    private boolean occupied;
    
    private VehicleType supportedVehicleType;

    private Vehicle currentParkedVehicle;

    public boolean isSpotOccupied() {
        return occupied;
    }

    public boolean canVehicleFitHere(Vehicle vehicle) {
        return !occupied && supportedVehicleType == vehicle.getVehicleType();
    }

    public void parkHere(Vehicle vehicle) {
        currentParkedVehicle = vehicle;
        occupied = true;
    }

    public void exitFromHere() {
        currentParkedVehicle = null;
        occupied = false;
    }
}
