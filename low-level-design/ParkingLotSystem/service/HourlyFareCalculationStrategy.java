package ParkingLotSystem.service;

import ParkingLotSystem.entity.Ticket;
import ParkingLotSystem.enums.VehicleType;
import ParkingLotSystem.strategies.FareCalculationStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class HourlyFareCalculationStrategy implements FareCalculationStrategy {
    HashMap<String,Double> fares = new HashMap<>(
            Map.of(
                    "BIKE", 20.00,
                    "CAR", 50.00,
                    "TRUCK", 100.00
            )
    );



    @Override
    public Double calculateFare(Ticket ticket){

        LocalDateTime checkInTime = ticket.getCheckInDateTime();

        LocalDateTime curTime = LocalDateTime.now();

        Duration duration = Duration.between(checkInTime,curTime);

        Double parkedHours = (Double) Math.ceil(duration.toMinutes()/60.0);

        VehicleType vehicleType = ticket.getVehicle().getVehicleType();

        return parkedHours * fares.get(vehicleType.toString());
    }
}
