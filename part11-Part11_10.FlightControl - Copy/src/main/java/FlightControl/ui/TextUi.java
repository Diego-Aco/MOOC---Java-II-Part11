package FlightControl.ui;

import java.util.Collection;
import java.util.Scanner;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.logic.FlightControl;

public class TextUi {

    private FlightControl flightControl;
    private Scanner scanner;

    public TextUi(FlightControl flightControl, Scanner scanner) {
        this.flightControl = flightControl;
        this.scanner = scanner;
    }

    public void runUi() {
        runAirportAssetControl();
        System.out.println();
        runFlightControl();

    }

    private void runAirportAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println();

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print("> ");

            String action = this.scanner.nextLine();
            action = action.toLowerCase();

            if (action.equals("1")) {
                promptNewPlane();
            } else if (action.equals("2")) {
                promptNewFlight();
            } else if (action.equals("x")) {
                break;
            }
        }
    }

    private void runFlightControl() {

        System.out.println("Flight Control");
        System.out.println("------------");
        System.out.println();

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            System.out.print("> ");

            String action = this.scanner.nextLine();
            action = action.toLowerCase();

            if (action.equals("1")) {
                printAirplanes();   //TODO: implement this method
            } else if (action.equals("2")) {
                printFlights();     //TODO: implement this
            } else if (action.equals("3")) {
                handlePrintAirplaneDetails();
            } else if (action.equals("x")) {
                break;
            }
        }
    }

    //Asset Control methods
    private void promptNewPlane() { // Don't need to pass in scanner right?
        System.out.print("Give the airplane id: ");
        String id = this.scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.valueOf(scanner.nextLine());

        // Add plane to our FlightControl object's planes hashmap
        this.flightControl.addAirplane(id, capacity);
    }

    private void promptNewFlight() { // Don't need to pass in scanner?
        System.out.println("Give the airplane id: ");
        String planeID = scanner.nextLine();
        // look up the airplane from flightControl's attribute hashmap of airplanes
        Airplane airplane = this.flightControl.getAirplanes().get(planeID);

        System.out.print("Give the departure airport id: ");
        String departureID = scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String destinationID = scanner.nextLine();

        this.flightControl.addFlight(airplane, departureID, destinationID);
    }

    //Flight Control methods
    private void printAirplanes(){
        //get all airplanes
        Collection<Airplane> airplanes = this.flightControl.getAirplanes().values();
        for (Airplane airplane : airplanes){
            System.out.println(airplane);
        }
    }

    private void printFlights(){
        Collection<Flight> flights = this.flightControl.getFlights().values();
        for (Flight flight : flights){
            System.out.println(flight);
        }
    }

    private void handlePrintAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        String id = scanner.nextLine();
        //look up plane by id
        Airplane airplane = flightControl.getAirplanes().get(id);
        System.out.println(airplane);
    }

}
