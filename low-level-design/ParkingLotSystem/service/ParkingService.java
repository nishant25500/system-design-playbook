package ParkingLotSystem.service;

import ParkingLotSystem.entity.*;
import ParkingLotSystem.strategies.FareCalculationStrategy;
import ParkingLotSystem.strategies.SpotAllocationStrategy;

import java.util.HashSet;
import java.util.Set;

public class ParkingService {
    SpotAllocationStrategy allocationStrategy = new FirstAvailableSpotAllocationStrategy();
    FareCalculationStrategy fareCalculationStrategy = new HourlyFareCalculationStrategy();

    Set<Ticket> tickets = new HashSet<>();

    //park
    public Ticket park(Vehicle vehicle, ParkingLot parkingLot){
        ParkingSpot availableSpot = allocationStrategy.allocateSpot(vehicle.getVehicleType(), parkingLot);

        if(availableSpot == null){
            return null;
        }

        //spot occupied ture
        availableSpot.setOccupied(true);

        //generate ticket
        Ticket ticket = new Ticket(availableSpot, vehicle);


        tickets.add(ticket);

        return ticket;
    }



    //unpark
    public Receipt unpark(Ticket ticket){
        // check ticket validity
        if(tickets.contains(ticket)){
            ParkingSpot occupiedSpot = ticket.getParkingSpot();

            // unoccupied
            occupiedSpot.setOccupied(false);

            //calculate fare
            Double calculatedFare = fareCalculationStrategy.calculateFare(ticket);

            //remove ticket from record
            tickets.remove(ticket);

            return new Receipt(ticket.getTicketId(), calculatedFare);
        }

        //ticket invalid/lost
        return null;
    }
}
