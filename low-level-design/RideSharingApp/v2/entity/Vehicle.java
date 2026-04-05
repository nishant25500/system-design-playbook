package RideSharingApp.v2.entity;

public abstract class Vehicle {

    private String vehicle_number;

    public Vehicle(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public abstract Double getFarePerKm();

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

}
