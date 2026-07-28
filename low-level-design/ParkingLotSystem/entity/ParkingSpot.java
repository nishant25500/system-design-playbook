package ParkingLotSystem.entity;

import ParkingLotSystem.enums.SpotType;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {
    String spotId;

    SpotType spotType;

    private final AtomicBoolean occupied = new AtomicBoolean(false);

    int floorNumber;

    public ParkingSpot(String spotId, SpotType spotType, int floorNumber) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.floorNumber = floorNumber;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public Boolean reserve() {
        return this.occupied.compareAndSet(false, true);
    }

    public void release() {
        this.occupied.set(false);
    }

    public boolean isOccupied() {
        return occupied.get();
    }
//    public Boolean getOccupied() {
//        return isOccupied;
//    }
//
//    public void setOccupied(Boolean occupied) {
//        isOccupied = occupied;
//    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
