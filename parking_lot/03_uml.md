
+----------------+
|  ParkingLot   |
+----------------+
| - floors       |
| - pricing      |-----> PricingPolicy
| - allocator    |-----> SpotAllocationStrategy
+----------------+
        |
        v
+----------------+
| ParkingFloor  |
+----------------+
| - spots        |
+----------------+
        |
        v
+----------------+
| ParkingSpot   |
+----------------+
| - occupied     |
| - vehicleType  |
+----------------+

+--------+        +--------+
| Ticket |<------>| Vehicle|
+--------+        +--------+
