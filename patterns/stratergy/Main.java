package patterns.stratergy;

import patterns.stratergy.classes.PassengerCar;
import patterns.stratergy.classes.RacingCar;
import patterns.stratergy.classes.SportsCar;
import patterns.stratergy.classes.Vehicle;
import patterns.stratergy.stratergy.AdvancedDriving;
import patterns.stratergy.stratergy.BasicDriving;
import patterns.stratergy.stratergy.DrivingStratergy;

public class Main {
    public static void main(String[] args) {

        // Option A: cars can provide a default strategy internally
        Vehicle passCar = new PassengerCar();
        passCar.drive();


        DrivingStratergy basicDriving = new BasicDriving();
        DrivingStratergy advancedDriving = new AdvancedDriving();
        
        
        // Option B: cars can be injected with the drive stratergy explicitly
        Vehicle sportsCar = new SportsCar(basicDriving);
        sportsCar.drive();
        
        
        // Option C: you can also switch strategies at runtime
        Vehicle racingCar = new RacingCar();
        racingCar.setDrivingStrategy(advancedDriving);
        racingCar.drive();
    }
}
