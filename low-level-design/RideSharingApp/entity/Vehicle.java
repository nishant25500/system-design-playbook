package RideSharingApp.entity;

public class Vehicle {
    private String vehicle_name;
    private String vehicle_number;
    private String vehicle_type;

    public Vehicle(String vehicle_name, String vehicle_number, String vehicle_type) {
        this.vehicle_name = vehicle_name;
        this.vehicle_number = vehicle_number;
        this.vehicle_type = vehicle_type;
    }


    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

}
