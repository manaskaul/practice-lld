package lld_04_zoomcar.classes;

import lld_04_zoomcar.enums.VehicleStatus;
import lld_04_zoomcar.enums.VehicleType;
import lombok.Getter;

@Getter
public class Vehicle {
    private String vehcleNumber;
    private VehicleType vehicleType;
    private VehicleStatus status;

    public Vehicle(String number, VehicleType type) {
        this.vehcleNumber = number;
        this.vehicleType = type;
        this.status = VehicleStatus.AVAILABLE;
    }

    public void updateVehicleStatus(VehicleStatus vehicleStatus) {
        status = vehicleStatus;
    }
}
