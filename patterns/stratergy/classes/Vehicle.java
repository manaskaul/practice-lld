package patterns.stratergy.classes;

import patterns.stratergy.stratergy.DrivingStratergy;

public class Vehicle {

    private DrivingStratergy drivingStratergy;

    public Vehicle(DrivingStratergy ds) {
        this.drivingStratergy = ds;
    }

    public void drive() {
        drivingStratergy.drive();
    }
    
    // OPTION C: Set driving stratergy at runtime
    public void setDrivingStrategy(DrivingStratergy ds) {
        this.drivingStratergy = ds;
    }
}
