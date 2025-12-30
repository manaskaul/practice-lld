package patterns.stratergy.classes;

import patterns.stratergy.stratergy.DrivingStratergy;
import patterns.stratergy.stratergy.AdvancedDriving;

public class RacingCar extends Vehicle {

    // OPTION A: Set to use the Advanced Driving stratergy by default
    public RacingCar() {
        super(new AdvancedDriving());
    }

    // OPTION B: Can be set explicitly set during object initlization
    public RacingCar(DrivingStratergy ds) {
        super(ds);
    }
    
    // OPTION C: Can be set at runtime
    // This is done via the parent class - Vehicle
}