package ParkingLotSystem.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


public class Ticket {
    String ticketId;

    ParkingSpot parkingSpot;

    Vehicle vehicle;

    LocalDateTime checkInDateTime;

    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle) {
        this.ticketId = UUID.randomUUID().toString();
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.checkInDateTime = LocalDateTime.now();
    }


    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getCheckInDateTime() {
        return checkInDateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Objects.equals(ticketId, ticket.ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ticketId);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", parkingSpot=" + parkingSpot.spotId +
                ", vehicle=" + vehicle.vehicleNumber +
                ", floor=" + parkingSpot.floorNumber +
                ", checkInDateTime=" + checkInDateTime +
                '}';
    }
}
