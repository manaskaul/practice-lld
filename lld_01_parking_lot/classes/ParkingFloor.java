package lld_01_parking_lot.classes;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingFloor {
    private List<ParkingSpot> spots;

    public List<ParkingSpot> getAvailableParkingSpots() {
        return spots.stream()
                .filter(spot -> !spot.isOccupied())
                .toList();
    }
}
