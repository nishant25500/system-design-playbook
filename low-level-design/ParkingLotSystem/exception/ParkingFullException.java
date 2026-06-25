package ParkingLotSystem.exception;

public class ParkingFullException extends RuntimeException{

    public ParkingFullException(String msg){
        super(msg);
    }
}
