package RideSharingApp.v2.service;


import RideSharingApp.v2.entity.Vehicle;

public interface FareCalStrategy {
    Double calFare(Vehicle vehicle,Double distance);
}

//different fareCalStrategies are: Standard, Sharing, Luxury


