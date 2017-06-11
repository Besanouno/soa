package pl.basistam.soa.main.carPark;

import lombok.Getter;
import pl.basistam.dataAccess.api.CarParkDao;
import pl.basistam.dataAccess.entities.Ticket;
import pl.basistam.soa.main.EjbBindings;
import pl.basistam.soa.main.WrongParkingSpotNumberException;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.time.LocalDateTime;
import java.util.*;

@Singleton(name="CarPark")
public class CarPark {
    private final long NUMBER_OF_PARKING_SPOTS;
    @Getter
    private TreeMap<Integer, LocalDateTime> unpaidParkingSpots = new TreeMap<>();
    @Getter
    private Map<Integer, Ticket> paidParkingSpots = new TreeMap<>();
    @Getter
    private Map<Integer, LocalDateTime> expiredParkingSpots = new TreeMap<>();

    private CarParkDao carParkDao;

    public CarPark() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(InitialContext.PROVIDER_URL, "remote://localhost:4447");
        final Context context = new InitialContext(jndiProperties);
        carParkDao = (CarParkDao) context.lookup(EjbBindings.CarParkDao_JNDI);
        NUMBER_OF_PARKING_SPOTS = carParkDao.getParkingSpotNumber();
    }

    public boolean takeParkingSpot(int parkingSpotId, LocalDateTime timeOfParking) throws WrongParkingSpotNumberException {
        validate(parkingSpotId);
        if (!unpaidParkingSpots.containsKey(parkingSpotId)) {
            unpaidParkingSpots.put(parkingSpotId, timeOfParking);
            return true;
        }
        return false;
    }

    public boolean releaseParkingSpot(int parkingSpotId) throws WrongParkingSpotNumberException {
        validate(parkingSpotId);
        if (unpaidParkingSpots.containsKey(parkingSpotId)) {
            unpaidParkingSpots.remove(parkingSpotId);
            return true;
        } else if (paidParkingSpots.containsKey(parkingSpotId)) {
            paidParkingSpots.remove(parkingSpotId);
            return true;
        } else if (expiredParkingSpots.containsKey(parkingSpotId)) {
            expiredParkingSpots.remove(parkingSpotId);
            return true;
        }
        return false;
    }

    public boolean payForParkingSpot(int parkingSpotId, Ticket ticket) throws WrongParkingSpotNumberException {
        validate(parkingSpotId);
        if (unpaidParkingSpots.containsKey(parkingSpotId)) {
            unpaidParkingSpots.remove(parkingSpotId);
            paidParkingSpots.put(parkingSpotId, ticket);
            return true;
        } else if (expiredParkingSpots.containsKey(parkingSpotId)) {
            expiredParkingSpots.remove(parkingSpotId);
            paidParkingSpots.put(parkingSpotId, ticket);
            return true;
        } else if (paidParkingSpots.containsKey(parkingSpotId)) {
            paidParkingSpots.put(parkingSpotId, ticket);
            return true;
        }
        return false;
    }

    private void validate(int parkingSpot) throws WrongParkingSpotNumberException {
        if (parkingSpot < 1 || parkingSpot > NUMBER_OF_PARKING_SPOTS) {
            throw new WrongParkingSpotNumberException("Wrong parking spot number");
        }
    }

    public Ticket getNextExpiringTicket() {
        return paidParkingSpots.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .min(Comparator.comparing(Ticket::getTimeOfExpiration))
                .orElse(null);
    }

    public void expireTicket(int parkingSpotId, LocalDateTime timeOfExpiration) {
        paidParkingSpots.remove(parkingSpotId);
        expiredParkingSpots.put(parkingSpotId, timeOfExpiration);
    }

    public void expireTimeToBuyTicket(int parkingSpotId, LocalDateTime timeOfExpiration) {
        unpaidParkingSpots.remove(parkingSpotId);
        expiredParkingSpots.put(parkingSpotId, timeOfExpiration);
    }

    public Integer getAreaForParkingSpot(Integer parkingSpot) {
        return carParkDao.getParkingSpot(parkingSpot).getArea();
    }

    public Map.Entry<Integer, LocalDateTime> getFirstUnpaidParkingSpot() {
        return unpaidParkingSpots.firstEntry();
    }
}
