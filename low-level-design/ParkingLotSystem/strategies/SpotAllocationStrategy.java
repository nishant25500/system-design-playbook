package ParkingLotSystem.strategies;

import ParkingLotSystem.entity.ParkingLot;
import ParkingLotSystem.entity.ParkingSpot;
import ParkingLotSystem.enums.VehicleType;

import java.util.List;

public interface SpotAllocationStrategy {
    ParkingSpot allocateSpot(VehicleType vehicleType, ParkingLot parkingLot);
}
