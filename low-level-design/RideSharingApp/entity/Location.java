package RideSharingApp.entity;

public class Location {
    private Double longitude;
    private Double latitude;

    public Location(Double latitude,Double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLongitude(){
        return this.longitude;
    }

    public Double getLatitude(){
        return this.latitude;
    }

    void setLongitude(){
        this.longitude = longitude;
    }

    void setLatitude(){
        this.latitude = latitude;
    }

}
