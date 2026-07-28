package ParkingLotSystem.client;

import ParkingLotSystem.entity.*;
import ParkingLotSystem.enums.SpotType;
import ParkingLotSystem.enums.VehicleType;
import ParkingLotSystem.exception.InvalidTicketException;
import ParkingLotSystem.exception.ParkingFullException;
import ParkingLotSystem.service.ParkingService;
import ParkingLotSystem.strategies.FirstAvailableSpotAllocationStrategy;
import ParkingLotSystem.strategies.HourlyFareCalculationStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        System.out.println("I am Client from Parking Lot System");
        // Data seeding

        //vehicles
        List<Vehicle> vehicles = List.of(
                new Vehicle("UP 65 9130", VehicleType.BIKE),
                new Vehicle("UP 63 1111", VehicleType.CAR),
                new Vehicle("UP 32 0000", VehicleType.TRUCK)
        );

//        for(Vehicle x: vehicles){
//            System.out.println(x.getVehicleNumber()+" "+x.getVehicleType());
//        }

        //floors
        ParkingFloor floor1 = new ParkingFloor(List.of(
                new ParkingSpot("S-101", SpotType.CAR, 1),
                new ParkingSpot("S-102", SpotType.CAR, 1),
                new ParkingSpot("S-111", SpotType.BIKE, 1),
                new ParkingSpot("S-112", SpotType.BIKE, 1),
                new ParkingSpot("S-121", SpotType.TRUCK, 1),
                new ParkingSpot("S-122", SpotType.TRUCK, 1)
        ));

        ParkingFloor floor2 = new ParkingFloor(List.of(
                new ParkingSpot("S-101", SpotType.CAR, 2),
                new ParkingSpot("S-102", SpotType.CAR, 2),
                new ParkingSpot("S-111", SpotType.BIKE, 2),
                new ParkingSpot("S-112", SpotType.BIKE, 2),
                new ParkingSpot("S-121", SpotType.TRUCK, 2),
                new ParkingSpot("S-122", SpotType.TRUCK, 2)
        ));

        List<ParkingFloor> floors = List.of(floor1, floor2);

        //parking lot
        ParkingLot parkingLot = ParkingLot.getInstance(List.of(floor1, floor2));

        ParkingService parkingService = new ParkingService(new FirstAvailableSpotAllocationStrategy(), new HourlyFareCalculationStrategy());

        Ticket ticket1 = null, ticket2 = null, ticket3 = null, ticket4 = null, ticket5 = null;

        try {
            ticket1 = parkingService.park(vehicles.get(1), parkingLot);
            System.out.println("Parked V1!! Please find the ticket below");
            System.out.println(ticket1);
        } catch (ParkingFullException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            ticket2 = parkingService.park(vehicles.get(1), parkingLot);
            System.out.println("Parked V2!! Please find the ticket below");
            System.out.println(ticket2);
        } catch (ParkingFullException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            ticket3 = parkingService.park(vehicles.get(1), parkingLot);
            System.out.println("Parked V3!! Please find the ticket below");
            System.out.println(ticket3);
        } catch (ParkingFullException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            ticket4 = parkingService.park(vehicles.get(1), parkingLot);
            System.out.println("Parked V4!! Please find the ticket below");
            System.out.println(ticket4);
        } catch (ParkingFullException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        //unpark
        try {
            Receipt receiptForCar1 = parkingService.unpark(null);
            System.out.println(receiptForCar1);
        } catch (InvalidTicketException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            ticket5 = parkingService.park(vehicles.get(1), parkingLot);
            System.out.println("Parked V5!! Please find the ticket below");
            System.out.println(ticket5);
        } catch (ParkingFullException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
