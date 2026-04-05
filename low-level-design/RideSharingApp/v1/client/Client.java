package RideSharingApp.v1.client;

import RideSharingApp.v1.entity.Driver;
import RideSharingApp.v1.entity.Location;
import RideSharingApp.v1.entity.Passenger;
import RideSharingApp.v1.entity.Vehicle;
import RideSharingApp.v1.services.RideBookingService;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args){
        Location loc1 = new Location(123.00,2500.00);
        Location loc2 = new Location(150.00,250.00);
        Location loc3 = new Location(200.00,300.00);
        Location loc4 = new Location(400.00,550.00);

        //vehicles
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Hero Rider","ABCD","Bike"));
        vehicles.add(new Vehicle("Swift Dzire","EFGH","Car"));
        vehicles.add(new Vehicle("Green Apte","IJKL","Auto"));

        //drivers
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Raju",loc2,vehicles.get(1)));
        drivers.add(new Driver("Ram",loc1,vehicles.get(2)));
        drivers.add(new Driver("Laxan",loc3,vehicles.get(0)));

        //passengers
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("Nishant",loc4));


        RideBookingService ride = new RideBookingService((long)12345678,drivers,passengers);

        System.out.println(ride.bookRide(passengers.get(0),20.00));
    }
}
