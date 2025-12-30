package patterns.stratergy.classes;

import patterns.stratergy.stratergy.DrivingStratergy;
import patterns.stratergy.stratergy.AdvancedDriving;

public class SportsCar extends Vehicle {

    // OPTION A: Set to use the Advanced Driving stratergy by default
    public SportsCar() {
        super(new AdvancedDriving());
    }

    // Object B: Can be set explicitly set during object initlization
    public SportsCar(DrivingStratergy ds) {
        super(ds);
    }
    
    // OPTION C: Can be set at runtime
    // This is done via the parent class - Vehicle
}
