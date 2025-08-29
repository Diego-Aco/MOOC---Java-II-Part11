package FlightControl.logic;
import java.util.HashMap;

import FlightControl.domain.*; //we can't use Airplane/Flight/Place without this import

public class FlightControl {
    
    private HashMap<String, Place> places;
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights;

    public FlightControl(){
        this.places=new HashMap<>();
        this.airplanes= new HashMap<>();
        this.flights = new HashMap<>();
    }

    public void addPlace(String id){
        Place place = new Place(id);
        this.places.put(id, place);
    }

    public void addAirplane(String id, int capacity) {
        Airplane airplane = new Airplane(id, capacity);
        this.airplanes.put(id, airplane);
    }

    public void addFlight(Airplane airplane, String departureID, String destinationID){
        //Create Places from the dep/dest IDs and add them to the hashmaps if not already there
        Place departure = new Place(departureID);
        places.putIfAbsent(departureID, departure);
        Place destination = new Place(destinationID);
        places.putIfAbsent(destinationID, destination);
        
        Flight flight = new Flight(airplane, places.get(departureID), places.get(destinationID));
        flights.putIfAbsent(flight.toString(), flight);
    }

    public HashMap<String, Place> getPlaces() {
        return places;
    }

    public HashMap<String, Airplane> getAirplanes() {
        return airplanes;
    }

    public HashMap<String, Flight> getFlights() {
        return flights;
    }

}
