package RideSharingApp.v2.service;

import RideSharingApp.v2.entity.Vehicle;

public class LuxuryFareCalStrategy implements FareCalStrategy{
    @Override
    public Double calFare(Vehicle vehicle, Double distance) {
        return vehicle.getFarePerKm() * distance * 1.5; // 50% extra fare on luxury
    }
}
