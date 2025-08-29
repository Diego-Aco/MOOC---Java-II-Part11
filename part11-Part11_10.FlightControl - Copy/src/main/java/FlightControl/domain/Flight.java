package FlightControl.domain;

public class Flight {
    private Airplane airplane;
    private Place departure;
    private Place destination;

    public Flight(Airplane airplane, Place dep, Place dest){
        this.airplane=airplane;
        this.departure=dep;
        this.destination=dest;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Place getDeparture() {
        return departure;
    }

    public Place getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return String.format("%s (%s-%s)", this.airplane.toString(), this.departure, this.destination);
    }
    
}
