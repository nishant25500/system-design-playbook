package ParkingLotSystem.strategies;

import ParkingLotSystem.entity.Ticket;
import ParkingLotSystem.entity.Vehicle;

public interface FareCalculationStrategy {
    Double calculateFare(Ticket ticket);
}
