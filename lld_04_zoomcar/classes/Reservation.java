package lld_04_zoomcar.classes;

import lld_04_zoomcar.enums.ReservationStatus;
import lombok.Getter;

@Getter
public class Reservation {
    private int reservationId;
    private Store store;
    private Vehicle vehicle;
    private TimeWindow reservationTimeWindow;
    private ReservationStatus reservationStatus;

    public Reservation(int id, Store store, Vehicle vehicle, TimeWindow window, ReservationStatus status) {
        this.reservationId = id;
        this.store = store;
        this.vehicle = vehicle;
        this.reservationTimeWindow = window;
        this.reservationStatus = status;
    }

    public boolean isReservationActive() {
        if(reservationStatus == ReservationStatus.RETURNED || reservationStatus == ReservationStatus.CANCELLED) {
            return false;
        } else {
            return true;
        }
    }

    public void markReservationPaid() {
        reservationStatus = ReservationStatus.PAID;
    }

    public void markReservationPickedUp() {
        reservationStatus = ReservationStatus.PICKED_UP;
    }

    public void markReservationReturned() {
        reservationStatus = ReservationStatus.RETURNED;
    }

    public void markReservationCancelled() {
        reservationStatus = ReservationStatus.CANCELLED;
    }
}
