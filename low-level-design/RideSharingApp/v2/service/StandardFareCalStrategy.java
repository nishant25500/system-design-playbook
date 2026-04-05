package RideSharingApp.v2.service;

import RideSharingApp.v2.entity.Vehicle;

public class StandardFareCalStrategy implements FareCalStrategy{

    @Override
    public Double calFare(Vehicle vehicle, Double distance) {
        return vehicle.getFarePerKm() * distance;
    }
}
