package pl.basistam.soa.main.webService;

import pl.basistam.dataAccess.api.CarParkDao;
import pl.basistam.dataAccess.entities.Parking;
import pl.basistam.soa.main.EjbBindings;
import pl.basistam.soa.main.WrongParkingSpotNumberException;
import pl.basistam.soa.main.carPark.CarPark;
import pl.basistam.soa.main.notificators.UnpaidParkingNotifier;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.LocalDateTime;

@WebService
public class ParkingSensorsService {

    @Inject
    private CarPark carPark;

    @Inject
    private UnpaidParkingNotifier unpaidParkingNotifier;

    @EJB(mappedName = EjbBindings.CarParkDao_JNDI)
    private CarParkDao carParkDAO;

    @WebMethod
    public boolean takeParkingSpot(int parkingSpot) {
        try {
            LocalDateTime timeOfParking = LocalDateTime.now();
            if (carPark.takeParkingSpot(parkingSpot, timeOfParking)) {
                carParkDAO.saveParking(new Parking(parkingSpot, timeOfParking));
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
            return carPark.releaseParkingSpot(parkingSpot);
        } catch (WrongParkingSpotNumberException e) {
            return false;
        }
    }
}
