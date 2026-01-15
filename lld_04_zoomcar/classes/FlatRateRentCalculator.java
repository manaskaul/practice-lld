package lld_04_zoomcar.classes;

import lld_04_zoomcar.enums.VehicleType;
import lld_04_zoomcar.interfaces.RentCalculationStratergy;

public class FlatRateRentCalculator implements RentCalculationStratergy {

    @Override
    public double calculateRentalCharge(Vehicle vehicle, TimeWindow window) {
        int hrs = window.getEndTime() - window.getStartTime();
        switch (vehicle.getVehicleType()) {
            case VehicleType.HATCHBACK:
                return 1.0 * hrs;
            case VehicleType.SEDAN:
                return 2.0 * hrs;
            case VehicleType.SUV:
                return 2.5 * hrs;
            case VehicleType.COUPE:
                return 3.0 * hrs;
            default:
                return 10.0;
        }
    }
    
}
