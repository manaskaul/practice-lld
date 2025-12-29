package parking_lot.classes;

import lombok.Getter;
import lombok.Setter;

import parking_lot.enums.VehicleType;

@Getter
@Setter
public class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;
}
