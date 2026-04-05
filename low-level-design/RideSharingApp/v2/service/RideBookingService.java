package RideSharingApp.v2.service;

import RideSharingApp.v2.entity.*;

import java.util.ArrayList;
import java.util.List;

public class RideBookingService {
    private List<Driver> drivers = new ArrayList<>();

    public RideBookingService(){

    }

    public void addDriver(Driver driver){
        drivers.add(driver);
    }

    public void bookRide(Passenger passenger,Double distanceToTravel,FareCalStrategy fareCalStrategy){
        //no drivers available
        if(drivers.isEmpty()){
            passenger.notify("No drivers available at the moment try again later!");
            return;
        }

        //find nearest driver to assign the ride
        Driver assignedDriver = nearestDriver(passenger.getLocation());

        // remove driver from available driver
        drivers.remove(assignedDriver);

//        passenger.notify("Hi "+passenger.getName()+" your rider " + assignedDriver.getName() + "is on the way to the pickup location. Have a safe ride!");

        // new ride created
        Ride ride = new Ride(passenger,assignedDriver,fareCalStrategy,distanceToTravel);

        //cal fare
        Double rideFare = ride.fareCal(assignedDriver.getVehicle(),distanceToTravel);

        passenger.notify("Your is scheduled with fare Rs."+rideFare);
        assignedDriver.notify("New Ride is scheduled with fare Rs."+rideFare);

        //update status of ride to Ongoing
        ride.updateStatus(RideStatus.Ongoing);

        //update status of ride to Ongoing
        ride.updateStatus(RideStatus.Completed);

        // assigned driver is available for other rides
        drivers.add(assignedDriver);
    }

    private Driver nearestDriver(Location passengerLoc) {
        Driver assignedDriver = null;
        Double minDist = Double.MAX_VALUE;

        //use streams instead
        for (Driver driver : drivers) {
            Double distance = driver.getLocation().calDistance(passengerLoc);

            if (distance < minDist) {
                minDist = distance;
                assignedDriver = driver;
            }
        }


        assignedDriver.notify("Hi "+assignedDriver.getName()+" ride matched please move towards the pickup location!");

        return assignedDriver;
    }
}
