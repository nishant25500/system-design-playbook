package ParkingLotSystem.client;

import ParkingLotSystem.entity.*;
import ParkingLotSystem.enums.SpotType;
import ParkingLotSystem.enums.VehicleType;
import ParkingLotSystem.service.ParkingService;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args){
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
                new ParkingSpot("S-101", SpotType.CAR,false,1),
                new ParkingSpot("S-102", SpotType.CAR,false,1),
                new ParkingSpot("S-111", SpotType.BIKE,false,1),
                new ParkingSpot("S-112", SpotType.BIKE,false,1),
                new ParkingSpot("S-121", SpotType.TRUCK,false,1),
                new ParkingSpot("S-122", SpotType.TRUCK,false,1)
        ));

        ParkingFloor floor2 = new ParkingFloor(List.of(
                new ParkingSpot("S-101", SpotType.CAR,false,2),
                new ParkingSpot("S-102", SpotType.CAR,false,2),
                new ParkingSpot("S-111", SpotType.BIKE,false,2),
                new ParkingSpot("S-112", SpotType.BIKE,false,2),
                new ParkingSpot("S-121", SpotType.TRUCK,false,2),
                new ParkingSpot("S-122", SpotType.TRUCK,false,2)
        ));

        List<ParkingFloor> floors = List.of(floor1, floor2);

        //parking lot
        ParkingLot parkingLot = ParkingLot.getInstance(List.of(floor1, floor2));

        ParkingService parkingService = new ParkingService();


        Ticket ticket1 = parkingService.park(vehicles.get(1), parkingLot);
        Ticket ticket2 = parkingService.park(vehicles.get(1), parkingLot);
        Ticket ticket3 = parkingService.park(vehicles.get(1), parkingLot);
        Ticket ticket4 = parkingService.park(vehicles.get(1), parkingLot);


        if(ticket1 != null){
            System.out.println("Parked V1!! Please find the ticket below");
            System.out.println(ticket1);
        }
        if(ticket2 != null){
            System.out.println("Parked V2!! Please find the ticket below");
            System.out.println(ticket2);
        }
        if(ticket3 != null){
            System.out.println("Parked V3!! Please find the ticket below");
            System.out.println(ticket3);
        }
        if(ticket4 != null){
            System.out.println("Parked V4!! Please find the ticket below");
            System.out.println(ticket4);
        }

        Receipt receiptForCar1 = parkingService.unpark(ticket1);

        if(receiptForCar1 == null){
            System.out.println("Smthng went wrong");
        }

        System.out.println(receiptForCar1);

        Ticket ticket5 = parkingService.park(vehicles.get(1), parkingLot);
        if (ticket5 != null) {
            System.out.println("Parked V5!! Please find the ticket below");
            System.out.println(ticket5);
        }else{
            System.out.println("Parking full!!!!!");
        }

    }
}
