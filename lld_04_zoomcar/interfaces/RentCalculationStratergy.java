package lld_04_zoomcar.interfaces;

import lld_04_zoomcar.classes.TimeWindow;
import lld_04_zoomcar.classes.Vehicle;

public interface RentCalculationStratergy {
    
    public double calculateRentalCharge(Vehicle vehicle, TimeWindow window);

}
