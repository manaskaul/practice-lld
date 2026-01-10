package lld_00_patterns.stratergy.classes;

import lld_00_patterns.stratergy.stratergy.BasicDriving;
import lld_00_patterns.stratergy.stratergy.DrivingStratergy;

public class PassengerCar extends Vehicle {

    // OPTION A: Set to use the Basic Driving stratergy by default
    public PassengerCar() {
        super(new BasicDriving());
    }
    
    // OPTION B: Can be set explicitly set during object initlization
    public PassengerCar(DrivingStratergy ds) {
        super(ds);
    }
    
    // OPTION C: Can be set at runtime
    // This is done via the parent class - Vehicle
}
