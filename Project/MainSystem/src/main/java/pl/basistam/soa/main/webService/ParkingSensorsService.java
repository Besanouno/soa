package pl.basistam.soa.main.webService;

import pl.basistam.soa.main.WrongParkingSpotNumberException;
import pl.basistam.soa.main.model.Parking;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ParkingSensorsService {

    @Inject
    private Parking parking;

    @WebMethod
    public boolean takeParkingSpot(int area, int parkingSpot) {
        try {
            return parking.takeParkingSpot(area, parkingSpot);
        } catch (WrongParkingSpotNumberException e) {
            return false;
        }
    }
}
