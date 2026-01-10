package lld_01_parking_lot.interfaces;

import lld_01_parking_lot.classes.Ticket;

public interface PricingStratergy {
    double calculateFee(Ticket ticket);
}
