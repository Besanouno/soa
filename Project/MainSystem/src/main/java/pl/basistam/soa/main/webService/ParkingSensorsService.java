package pl.basistam.soa.main.webService;

import pl.basistam.soa.main.model.Parking;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ParkingSensorsService {

    @Inject
    private Parking parking;

    @WebMethod
    public void takeParkingSpot(int area, int parkingSpot) {
         
    }
}
