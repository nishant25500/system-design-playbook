package ParkingLotSystem.service;

import ParkingLotSystem.entity.*;
import ParkingLotSystem.exception.InvalidTicketException;
import ParkingLotSystem.exception.ParkingFullException;
import ParkingLotSystem.strategies.FareCalculationStrategy;
import ParkingLotSystem.strategies.FirstAvailableSpotAllocationStrategy;
import ParkingLotSystem.strategies.HourlyFareCalculationStrategy;
import ParkingLotSystem.strategies.SpotAllocationStrategy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingService {
    private final SpotAllocationStrategy allocationStrategy;
    private final FareCalculationStrategy fareCalculationStrategy;

    public ParkingService(SpotAllocationStrategy allocationStrategy, FareCalculationStrategy fareCalculationStrategy) {
        this.allocationStrategy = allocationStrategy;
        this.fareCalculationStrategy = fareCalculationStrategy;
    }

    // Use Concurrent HashMap to tickets
    private final Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();

    //park
    public Ticket park(Vehicle vehicle, ParkingLot parkingLot) {

        // TODO: Make allocation atomic/thread-safe
        ParkingSpot availableSpot = allocationStrategy.allocateSpot(vehicle.getVehicleType(), parkingLot);

        if (availableSpot == null) {
            throw new ParkingFullException(
                    "No parking spot available, Parking Full!"
            );
        }

        //generate ticket
        Ticket ticket = new Ticket(availableSpot, vehicle);

        //add ticket
        activeTickets.putIfAbsent(ticket.getTicketId(), ticket);

        return ticket;
    }


    //unpark
    public Receipt unpark(Ticket ticket) {
        // check ticket validity
        //remove ticket from record and return
        Ticket activeTicket =
                activeTickets.remove(ticket.getTicketId());

        if (activeTicket == null) {
            throw new InvalidTicketException("Invalid Ticket");
        }

        ParkingSpot occupiedSpot = activeTicket.getParkingSpot();

        // unoccupied
        occupiedSpot.release();

        //calculate fare
        Double calculatedFare = fareCalculationStrategy.calculateFare(activeTicket);


        return new Receipt(ticket.getTicketId(), calculatedFare);
    }
}
