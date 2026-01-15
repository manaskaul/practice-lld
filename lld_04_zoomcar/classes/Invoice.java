package lld_04_zoomcar.classes;

import lombok.Getter;

@Getter
public class Invoice {
    private Vehicle vehicle;
    private TimeWindow window;

    public Invoice(Vehicle vehicle, TimeWindow window) {
        this.vehicle = vehicle;
        this.window = window;
    }
}
