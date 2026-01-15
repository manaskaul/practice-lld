package lld_04_zoomcar.classes;

import java.util.ArrayList;
import java.util.List;

import lld_04_zoomcar.enums.VehicleStatus;

public class Store {
    private int storeId;
    private String storeName;
    private String location;
    private List<Vehicle> vehicleInventory;

    public Store(int id, String name, String loc) {
        this.storeId = id;
        this.storeName = name;
        this.location = loc;
        this.vehicleInventory = new ArrayList<>();
    }

    public void addNewVehicleToInventory(Vehicle vehicle) {
        vehicleInventory.add(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleInventory
                    .stream()
                    .filter(v -> v.getStatus().equals(VehicleStatus.AVAILABLE))
                    .toList();
    }
}
