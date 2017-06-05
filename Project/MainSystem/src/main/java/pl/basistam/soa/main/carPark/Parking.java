package pl.basistam.soa.main.carPark;

import lombok.Getter;
import pl.basistam.soa.main.WrongParkingSpotNumberException;

import javax.ejb.Singleton;
import java.time.LocalDateTime;
import java.util.*;

@Singleton
public class Parking {
    private final int NUMBER_OF_PARKING_SPOTS = 120;

    @Getter
    private TreeMap<Integer, LocalDateTime> unpaidParkingSpots = new TreeMap<>();
    @Getter
    private Map<Integer, Ticket> paidParkingSpots = new TreeMap<>();
    @Getter
    private Set<Integer> expiredParkingSpots = new TreeSet<>();

    public Parking() {
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
            System.out.println("Usunalem " + parkingSpotId + " z unpaid, obecny stan " + unpaidParkingSpots.size() );
            paidParkingSpots.put(parkingSpotId, ticket);
            return true;
        } else if (expiredParkingSpots.contains(parkingSpotId)) {
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

    public void expireTicket(int parkingSpotId) {
        paidParkingSpots.remove(parkingSpotId);
        expiredParkingSpots.add(parkingSpotId);
    }

    public void expireTimeToBuyTicket(int parkingSpotId) {
        unpaidParkingSpots.remove(parkingSpotId);
        expiredParkingSpots.add(parkingSpotId);
    }

    public Map.Entry<Integer, LocalDateTime> getFirstUnpaidParkingSpot() {
        return unpaidParkingSpots.firstEntry();
    }
}
