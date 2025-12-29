package parking_lot.interfaces;

import parking_lot.classes.Ticket;

public interface PricingStratergy {
    double calculateFee(Ticket ticket);
}
