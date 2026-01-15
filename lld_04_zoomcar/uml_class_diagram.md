# ZoomCar - UML Class Diagram

```mermaid
classDiagram
    %% Enums
    class VehicleType {
        <<enumeration>>
        HATCHBACK
        SEDAN
        SUV
        COUPE
    }

    class VehicleStatus {
        <<enumeration>>
        AVAILABLE
        IN_USE
        IN_MAINTENANCE
    }

    class ReservationStatus {
        <<enumeration>>
        CREATED
        PAID
        PICKED_UP
        RETURNED
        CANCELLED
    }

    %% Interfaces
    class RentCalculationStratergy {
        <<interface>>
        +calculateRentalCharge(Vehicle, TimeWindow) double
    }

    %% Classes
    class Store {
        -int storeId
        -String storeName
        -String location
        -List~Vehicle~ vehicleInventory
        +Store(int, String, String)
        +addNewVehicleToInventory(Vehicle) void
        +getAllAvailableVehicles() List~Vehicle~
    }

    class Vehicle {
        -String vehcleNumber
        -VehicleType vehicleType
        -VehicleStatus status
        +Vehicle(String, VehicleType)
        +updateVehicleStatus(VehicleStatus) void
        +getVehcleNumber() String
        +getVehicleType() VehicleType
        +getStatus() VehicleStatus
    }

    class TimeWindow {
        -int startTime
        -int endTime
        +TimeWindow(int, int)
        +getStartTime() int
        +getEndTime() int
    }

    class Reservation {
        -int reservationId
        -Store store
        -Vehicle vehicle
        -TimeWindow reservationTimeWindow
        -ReservationStatus reservationStatus
        +Reservation(int, Store, Vehicle, TimeWindow, ReservationStatus)
        +isReservationActive() boolean
        +markReservationPaid() void
        +markReservationPickedUp() void
        +markReservationReturned() void
        +markReservationCancelled() void
        +getReservationId() int
        +getStore() Store
        +getVehicle() Vehicle
        +getReservationTimeWindow() TimeWindow
        +getReservationStatus() ReservationStatus
    }

    class ReservationService {
        -List~Reservation~ reservations
        -Random rand$
        +ReservationService()
        +createNewReservation(Store, Vehicle, TimeWindow) Reservation
        +getAllReservationsForVehicle(Vehicle) List~Reservation~
        +pickupVehicle(Reservation) void
        +returnVehicle(Reservation) void
        +cancelReservation(Reservation) void
    }

    class AvailabilityService {
        -ReservationService reservationService
        +AvailabilityService(ReservationService)
        +isVehicleAvailableInTimeWindow(Vehicle, TimeWindow) boolean
        +getAllAvailableVehiclesInTimeWindow(Store, VehicleType, TimeWindow) List~Vehicle~
    }

    class Invoice {
        -Vehicle vehicle
        -TimeWindow window
        +Invoice(Vehicle, TimeWindow)
        +getVehicle() Vehicle
        +getWindow() TimeWindow
    }

    class PaymentManager {
        +processPayment(Invoice) void
    }

    class FlatRateRentCalculator {
        +calculateRentalCharge(Vehicle, TimeWindow) double
    }

    %% Relationships
    RentCalculationStratergy <|.. FlatRateRentCalculator : implements

    Store "1" *-- "*" Vehicle : contains
    Vehicle --> VehicleType : uses
    Vehicle --> VehicleStatus : uses

    Reservation --> Store : references
    Reservation --> Vehicle : references
    Reservation --> TimeWindow : contains
    Reservation --> ReservationStatus : uses

    ReservationService "1" o-- "*" Reservation : manages
    ReservationService ..> Store : uses
    ReservationService ..> Vehicle : uses
    ReservationService ..> TimeWindow : uses

    AvailabilityService --> ReservationService : depends on
    AvailabilityService ..> Store : uses
    AvailabilityService ..> Vehicle : uses
    AvailabilityService ..> TimeWindow : uses
    AvailabilityService ..> VehicleType : uses

    Invoice --> Vehicle : references
    Invoice --> TimeWindow : references

    PaymentManager ..> Invoice : processes

    RentCalculationStratergy ..> Vehicle : uses
    RentCalculationStratergy ..> TimeWindow : uses
```

## Design Patterns Used

1. **Strategy Pattern**
   - `RentCalculationStratergy`: Encapsulates different rent calculation algorithms
   - Allows flexible pricing models (FlatRate, Hourly, Dynamic, etc.)

2. **Service Layer Pattern**
   - `ReservationService`: Manages reservation lifecycle
   - `AvailabilityService`: Handles availability checks and queries
   - `PaymentManager`: Processes payment operations

3. **Domain-Driven Design**
   - Clear separation between entities, services, and value objects
   - Rich domain models with business logic encapsulated in entities

## Key Design Decisions

- **Composition over Inheritance**: Services use composition to collaborate
- **Single Responsibility**: Each class has a focused purpose
- **Enum for State Management**: Type-safe status and type definitions
- **Time Window Abstraction**: Reusable time range representation
- **Separation of Concerns**: Availability logic separated from reservation management

## Class Responsibilities

| Class | Responsibility |
|-------|---------------|
| `Store` | Manages vehicle inventory for a specific location |
| `Vehicle` | Represents a rentable vehicle with its type and status |
| `Reservation` | Encapsulates booking information and lifecycle |
| `ReservationService` | Handles reservation CRUD operations |
| `AvailabilityService` | Checks vehicle availability and prevents double booking |
| `TimeWindow` | Value object representing a time interval |
| `Invoice` | Contains billing information for a reservation |
| `PaymentManager` | Processes payment transactions |
| `FlatRateRentCalculator` | Implements flat-rate pricing strategy |

## System Flow

1. **Search Availability**: User searches for available vehicles in a time window
   - `AvailabilityService` checks vehicle status and existing reservations
   
2. **Create Reservation**: User books an available vehicle
   - `ReservationService` creates new reservation with CREATED status
   
3. **Payment**: User pays for the reservation
   - `PaymentManager` processes payment
   - Reservation status updates to PAID
   
4. **Pickup**: User picks up the vehicle
   - Reservation status updates to PICKED_UP
   - Vehicle status changes to IN_USE
   
5. **Return**: User returns the vehicle
   - Reservation status updates to RETURNED
   - Vehicle status changes to AVAILABLE

## Extensibility

The system can be easily extended with:
- New pricing strategies (Dynamic pricing, Weekend rates, etc.)
- Additional vehicle types
- More reservation statuses
- Different payment methods
- Location-based pricing
