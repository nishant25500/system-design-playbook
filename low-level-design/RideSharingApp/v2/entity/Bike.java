package RideSharingApp.v2.entity;

public class Bike extends Vehicle{
    private String name;

    public Bike(String vehicle_name, String vehicle_number) {
        super(vehicle_number);
        this.name = vehicle_name;
    }

    @Override
    public Double getFarePerKm(){
        return 6.00;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

