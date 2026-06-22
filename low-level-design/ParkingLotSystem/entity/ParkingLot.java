package ParkingLotSystem.entity;

import java.util.List;

// this class is following Singleton design pattern as Parking Lot must be created only once in the entire system.
public class ParkingLot {
    List<ParkingFloor> parkingFloors;

    private static ParkingLot parkingLot;

    private ParkingLot(List<ParkingFloor> parkingFloors){
        this.parkingFloors = parkingFloors;
    }

    public static ParkingLot getInstance(List<ParkingFloor> parkingFloors){
        if(parkingLot == null){
            return new ParkingLot(parkingFloors);
        }
        return parkingLot;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
