package pl.basistam.soa.main.webService;

import pl.basistam.soa.main.WrongParkingSpotNumberException;
import pl.basistam.soa.main.carPark.Parking;
import pl.basistam.soa.main.notificators.UnpaidParkingNotifier;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.LocalDateTime;

@WebService
public class ParkingSensorsService {

    @Inject
    private Parking parking;

    @Inject
    private UnpaidParkingNotifier unpaidParkingNotifier;

    @WebMethod
    public boolean takeParkingSpot(int parkingSpot) {
        try {
            if (parking.takeParkingSpot(parkingSpot, LocalDateTime.now())) {
                unpaidParkingNotifier.update();
                return true;
            }
        } catch (WrongParkingSpotNumberException e) {
            System.out.println("ERROR");
        }
        return false;
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
