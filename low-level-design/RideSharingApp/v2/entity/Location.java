package RideSharingApp.v2.entity;

public class Location {
    private Double longitude;
    private Double latitude;

    public Location(Double latitude, Double longitude){
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

    public Double calDistance(Location loc2){
        //Calculating Eucledian distance

        Location loc1 = this;
        Double dx = loc1.latitude - loc2.latitude;
        Double dy = loc1.longitude - loc2.longitude;

        return Math.sqrt(dx*dx + dy*dy);
    }

}
