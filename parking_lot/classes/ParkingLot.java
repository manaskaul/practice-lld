package parking_lot.classes;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import parking_lot.interfaces.PricingStratergy;
import parking_lot.interfaces.SpotAllocationStratergy;

@Getter
@Setter
public class ParkingLot {
    private List<ParkingFloor> floors;

    private PricingStratergy pricing;

    private SpotAllocationStratergy spotAllocator;
    
    public Ticket parkVehicleAndReturnTicket(Vehicle vehicle) {
        ParkingSpot spot = spotAllocator.allocateSpot(vehicle, floors);

        if (spot == null) {
            throw new RuntimeException("No parking spot available");
        }

        spot.parkHere(vehicle);

        return new Ticket(LocalDateTime.now(), spot, vehicle);
    }
    
    public double exitVehicleAndReturnFee(Ticket ticket) {
        double fee = pricing.calculateFee(ticket);
        
        ticket.getSpot().exitFromHere();

        return fee;
    }
}
