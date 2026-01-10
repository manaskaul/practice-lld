package lld_01_parking_lot.classes;

import lld_01_parking_lot.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;
}
