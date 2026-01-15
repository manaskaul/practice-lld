package lld_04_zoomcar.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lld_04_zoomcar.enums.ReservationStatus;

public class ReservationService {
    
    private List<Reservation> reservations;
    
    private static Random rand = new Random();

    public ReservationService() {
        reservations = new ArrayList<>();
    }

    public Reservation createNewReservation(Store store, Vehicle vehicle, TimeWindow window) {
        // first check if reservation should not exist for this vehicle for this time window in this store
        Reservation newReservation = new Reservation(
            rand.nextInt(1000, 9999), 
            store, 
            vehicle, 
            window, 
            ReservationStatus.CREATED
        );

        reservations.add(newReservation);

        return newReservation;
    }

    public List<Reservation> getAllReservationsForVehicle(Vehicle vehicle) {
        return reservations
                    .stream()
                    .filter(r -> r.getVehicle().getVehcleNumber().equals(vehicle.getVehcleNumber()))
                    .toList();
    }

    public void pickupVehicle(Reservation reservation) {
        // check if the vehicle is paid them move to pickup
    }

    public void returnVehicle(Reservation reservation) {
        // check if the vehicle is picked up
    }

    public void cancelReservation(Reservation reservation) {
        // cancel if created
        // initiate refund if Paid
        // cannot cancel if picked up
    }
}
