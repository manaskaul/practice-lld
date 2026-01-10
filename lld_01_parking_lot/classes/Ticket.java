package lld_01_parking_lot.classes;

import java.time.Duration;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
    private LocalDateTime entryTime;

    private ParkingSpot spot;

    private Vehicle vehicle;

    public Ticket(LocalDateTime entryTime, ParkingSpot spot, Vehicle vehicle) {
        this.entryTime = entryTime;
        this.spot = spot;
        this.vehicle = vehicle;
    }

    public Duration getTotalParkDuration() {
        return Duration.between(entryTime, LocalDateTime.now());
    }
}
