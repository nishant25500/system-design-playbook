package RideSharingApp.v2.entity;

import RideSharingApp.v2.service.FareCalStrategy;


public class Ride {
    private Passenger passenger;
    private Driver driver;
    private FareCalStrategy fareCalStrategy;
    private RideStatus status;
    private Double distance;


    public Ride(Passenger passenger, Driver driver, FareCalStrategy fareCalStrategy, Double distance) {
        this.passenger = passenger;
        this.driver = driver;
        this.fareCalStrategy = fareCalStrategy;
        this.distance = distance;
        this.status = RideStatus.Scheduled;
    }

    public Double fareCal(Vehicle vehicle,Double distance){
        return vehicle.getFarePerKm() * distance;
    }

    //update status and notify subscribers (observer pattern)
    public void updateStatus(RideStatus status){
        this.status = status;
        notifyUsers(status);
    }
    
    public void notifyUsers(RideStatus status){
        passenger.notify("Your ride is "+status);
        driver.notify("Ride status: "+status);
    }
}
