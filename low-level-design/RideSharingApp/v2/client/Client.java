package RideSharingApp.v2.client;

import RideSharingApp.v2.service.FareCalStrategy;
import RideSharingApp.v2.service.LuxuryFareCalStrategy;
import RideSharingApp.v2.service.RideBookingService;
import RideSharingApp.v2.entity.*;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args){
        Location loc1 = new Location(123.00,2500.00);
        Location loc2 = new Location(150.00,250.00);
        Location loc3 = new Location(200.00,300.00);
        Location loc4 = new Location(400.00,550.00);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Bike("Hunter","UP65/1234"));
        vehicles.add(new Bike("FZ","UP65/5678"));
        vehicles.add(new Car("Thar","UP16/9012"));

        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Rahul",loc2,vehicles.get(0),"abc@gmail.com"));
        drivers.add(new Driver("Chaubey",loc1,vehicles.get(1),"abc@gmail.com"));
        drivers.add(new Driver("Upreti",loc3,vehicles.get(2),"abc@gmail.com"));

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("Nishant",loc4,"nishant@gmail.com"));
        passengers.add(new Passenger("Mishra",loc2,"mishra@gmail.com"));

        RideBookingService rideService = new RideBookingService();

        for(Driver driver:drivers){
            rideService.addDriver(driver);
        }

        rideService.bookRide(passengers.get(0),15.00,new LuxuryFareCalStrategy());
    }
}

