package ParkingLotSystem.entity;

public class Receipt {
    String ticketId;

    Double calculatedFare;

    public String getTicketId() {
        return ticketId;
    }

    public Receipt(String ticketId, Double calculatedFare) {
        this.ticketId = ticketId;
        this.calculatedFare = calculatedFare;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Double getCalculatedFare() {
        return calculatedFare;
    }

    public void setCalculatedFare(Double calculatedFare) {
        this.calculatedFare = calculatedFare;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "ticketId='" + ticketId + '\'' +
                ", calculatedFare=" + calculatedFare +
                '}';
    }
}
