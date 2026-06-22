package ParkingLotSystem.entity;

import ParkingLotSystem.enums.SpotType;

public class ParkingSpot {
    String spotId;

    SpotType spotType;

    Boolean isOccupied;

    int floorNumber;

    public ParkingSpot(String spotId, SpotType spotType, Boolean isOccupied, int floorNumber) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = isOccupied;
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

    public Boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
