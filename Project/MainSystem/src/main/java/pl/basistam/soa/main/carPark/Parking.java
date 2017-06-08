package pl.basistam.soa.main.carPark;

import lombok.Getter;
import pl.basistam.soa.main.WrongParkingSpotNumberException;
import pl.basistam.soa.main.carPark.xml.CarParkLayout;

import javax.ejb.Singleton;
import java.time.LocalDateTime;
import java.util.*;

@Singleton
public class Parking {
    private final int NUMBER_OF_PARKING_SPOTS;
    @Getter
    private TreeMap<Integer, LocalDateTime> unpaidParkingSpots = new TreeMap<>();
    @Getter
    private Map<Integer, Ticket> paidParkingSpots = new TreeMap<>();
    @Getter
    private Map<Integer, LocalDateTime> expiredParkingSpots = new TreeMap<>();

    private CarParkLayout carParkLayout = new CarParkLayout();

    public Parking() {
        NUMBER_OF_PARKING_SPOTS = carParkLayout.getParkingSpotsNumber();
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

    public int getAreaForParkingSpot(int parkingSpot) {
        return carParkLayout.getAreaForParkingSpot(parkingSpot);
    }

    public Map.Entry<Integer, LocalDateTime> getFirstUnpaidParkingSpot() {
        return unpaidParkingSpots.firstEntry();
    }
}
