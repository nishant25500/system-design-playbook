package RideSharingApp.entity;


public class Driver {
    private String name;
    private Location location;
    private Vehicle vehicle;

    public Driver(String name, Location location, Vehicle vehicle) {
        this.name = name;
        this.location = location;
        this.vehicle = vehicle;
    }

    public Location getLocation() {
        return this.location;
    }

    public Driver getDriver() {
        return this;
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public String getName(){
        return this.name;
    }
}
