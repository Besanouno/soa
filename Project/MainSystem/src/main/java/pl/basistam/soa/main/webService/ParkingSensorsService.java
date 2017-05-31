package pl.basistam.soa.main.webService;

import pl.basistam.soa.main.WrongParkingSpotNumberException;
import pl.basistam.soa.main.carPark.Parking;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ParkingSensorsService {

    @Inject
    private Parking parking;

    @WebMethod
    public boolean takeParkingSpot(int parkingSpot) {
        try {
            return parking.takeParkingSpot(parkingSpot);
        } catch (WrongParkingSpotNumberException e) {
            return false;
        }
    }

    @WebMethod
    public boolean releaseParkingSpot(int parkingSpot) {
        try {
            return parking.releaseParkingSpot(parkingSpot);
        } catch (WrongParkingSpotNumberException e) {
            return false;
        }
    }
}
