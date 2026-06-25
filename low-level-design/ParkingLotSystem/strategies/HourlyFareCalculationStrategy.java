package ParkingLotSystem.strategies;

import ParkingLotSystem.entity.Ticket;
import ParkingLotSystem.enums.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class HourlyFareCalculationStrategy implements FareCalculationStrategy {

    //improvement
    private static final Map<VehicleType,Double> fares = new HashMap<>(
            Map.of(
                    VehicleType.BIKE, 20.00,
                    VehicleType.CAR, 50.00,
                    VehicleType.TRUCK, 100.00
            )
    );



    @Override
    public Double calculateFare(Ticket ticket){

        LocalDateTime checkInTime = ticket.getCheckInDateTime();

        LocalDateTime curTime = LocalDateTime.now();

        Duration duration = Duration.between(checkInTime,curTime);

        Double parkedHours = Math.max(1.00 , (Double) Math.ceil(duration.toMinutes()/60.0));

        VehicleType vehicleType = ticket.getVehicle().getVehicleType();

        return parkedHours * fares.get(vehicleType);
    }
}
