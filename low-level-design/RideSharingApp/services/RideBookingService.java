package RideSharingApp.services;

import RideSharingApp.entity.Driver;
import RideSharingApp.entity.Location;
import RideSharingApp.entity.Passenger;
import RideSharingApp.entity.Vehicle;


import java.util.List;

public class RideBookingService {
    private Long rideId;
    private List<Driver> drivers;
    private List<Passenger> passengers;

    public RideBookingService(Long rideId, List<Driver> drivers, List<Passenger> passengers){
        this.rideId = rideId;
        this.drivers = drivers;
        this.passengers = passengers;
    }

    public String bookRide(Passenger passenger,Double destDistance){
        //corner case
        if(drivers.isEmpty()){
            System.out.println("No driver available at the moment for "+passenger.getName());
        }

        //find nearest driver
        Double minDistance = Double.MAX_VALUE;
        Driver assignedDriver = null;

        for(Driver driver:drivers){
            Double curDistance = calDistance(passenger.getLocation(),driver.getLocation());
            if(curDistance < minDistance){
                minDistance = curDistance;
                assignedDriver = driver;
            }
        }
        //track driver availability [To-DO]

        //fare cal
        Double rideFare = calFare(destDistance,assignedDriver.getVehicle());

        //book driver
        String res = "Ride booked for"+passenger.getName()+" with driver "+assignedDriver.getName()+" for a expected fare of "+rideFare;

        return res;
    }

    private Double calDistance(Location passengerLoc,Location driverLoc){
        // for simplicity we are calculating Euclidean distance here

        Double dx = passengerLoc.getLatitude() - driverLoc.getLatitude();
        Double dy = passengerLoc.getLongitude() - driverLoc.getLongitude();

        return Math.sqrt((dx*dx) + (dy*dy));
    }

    private Double calFare(Double dist, Vehicle vehicle){
        if(vehicle.getVehicle_type() == "Car"){
            return (double)dist * 100.00;
        }else if(vehicle.getVehicle_type() == "Bike"){
            return (double)dist * 30.00;
        }else if(vehicle.getVehicle_type() == "Auto"){
            return (double)dist * 60.00;
        }
        return (double)dist * 0.0;
    }


}


