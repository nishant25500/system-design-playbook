package RideSharingApp.v2.entity;

import RideSharingApp.v2.entity.Location;
import RideSharingApp.v2.entity.Vehicle;

public class Driver extends User{
    private Vehicle vehicle;

    public Driver(String name, Location location,Vehicle vehicle,String email){
        super(name,location,email);
        this.vehicle = vehicle;
    }

    @Override
    public void notify(String msg){
        System.out.println(msg);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
