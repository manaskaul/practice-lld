package lld_04_zoomcar.classes;

import java.util.List;

import lld_04_zoomcar.enums.VehicleStatus;
import lld_04_zoomcar.enums.VehicleType;

public class AvailabilityService {

    ReservationService reservationService;

    public AvailabilityService(ReservationService reservationService) {
        this.reservationService = reservationService;
    } 

    public boolean isVehicleAvailableInTimeWindow(Vehicle vehicle, TimeWindow window) {
        // check if vehicle is AVAILABLE in the time window
        // check all reservations for the vehicle

        if(vehicle.getStatus() != VehicleStatus.AVAILABLE) {
            return false;
        }
        
        List<Reservation> vehicleReservations = reservationService.getAllReservationsForVehicle(vehicle);
        
        for(Reservation reservation : vehicleReservations) {
            if(
                reservation.isReservationActive()
                &&
                window.getStartTime() < reservation.getReservationTimeWindow().getEndTime()
                &&
                window.getEndTime() > reservation.getReservationTimeWindow().getStartTime()
            ) {
                return false;
            }   
        }

        return true;
    }

    List<Vehicle> getAllAvailableVehiclesInTimeWindow(Store store, VehicleType vehicleType, TimeWindow window) {
        // iteratre through all available vehicles and filter out those that have overlap interval with window
        return store.getAllVehicles()
                .stream()
                .filter(vehicle -> vehicle.getVehicleType().equals(vehicleType) && isVehicleAvailableInTimeWindow(vehicle, window))
                .toList();
    }
}
