package ParkingLotSystem.service;

import ParkingLotSystem.entity.*;
import ParkingLotSystem.exception.InvalidTicketException;
import ParkingLotSystem.exception.ParkingFullException;
import ParkingLotSystem.strategies.FareCalculationStrategy;
import ParkingLotSystem.strategies.FirstAvailableSpotAllocationStrategy;
import ParkingLotSystem.strategies.HourlyFareCalculationStrategy;
import ParkingLotSystem.strategies.SpotAllocationStrategy;

import java.util.HashSet;
import java.util.Set;

public class ParkingService {
    private final SpotAllocationStrategy allocationStrategy ;
    private final FareCalculationStrategy fareCalculationStrategy ;

    public ParkingService(SpotAllocationStrategy allocationStrategy, FareCalculationStrategy fareCalculationStrategy){
        this.allocationStrategy = allocationStrategy;
        this.fareCalculationStrategy = fareCalculationStrategy;
    }

    // Todo: Use Concurrent HashMap to tickets
    Set<Ticket> tickets = new HashSet<>();

    //park
    public Ticket park(Vehicle vehicle, ParkingLot parkingLot){

        // TODO: Make allocation atomic/thread-safe
        ParkingSpot availableSpot = allocationStrategy.allocateSpot(vehicle.getVehicleType(), parkingLot);

        if(availableSpot == null){
            throw new ParkingFullException(
                    "No parking spot available, Parking Full!"
            );
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
        if(!tickets.contains(ticket))
            throw new InvalidTicketException("Invalid Ticket");

            ParkingSpot occupiedSpot = ticket.getParkingSpot();

            // unoccupied
            occupiedSpot.setOccupied(false);

            //calculate fare
            Double calculatedFare = fareCalculationStrategy.calculateFare(ticket);

            //remove ticket from record
            tickets.remove(ticket);

            return new Receipt(ticket.getTicketId(), calculatedFare);
    }
}
