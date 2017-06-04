package pl.basistam.soa.main.carPark;

import pl.basistam.soa.main.WrongParkingSpotNumberException;

import javax.ejb.Singleton;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Singleton
public class Parking {
    private final int NUMBER_OF_PARKING_SPOTS;
    private Map<Integer, ParkingSpot> freeParkingSpots = new HashMap<>();
    private Map<Integer, ParkingSpot> unpaidParkingSpots = new TreeMap<>();
    private Map<Integer, ParkingSpot> paidParkingSpots = new HashMap<>();

    public Parking() {
        int parkingSpotNumber = 1;
        parkingSpotNumber = initArea(1, parkingSpotNumber);
        parkingSpotNumber = initArea(2, parkingSpotNumber);
        parkingSpotNumber = initArea(3, parkingSpotNumber);
        parkingSpotNumber = initArea(4, parkingSpotNumber);
        NUMBER_OF_PARKING_SPOTS = parkingSpotNumber;
    }

    private int initArea(int areaId, int parkingSpotNumber) {
        for (int i = 0; i < 30; i++) {
            freeParkingSpots.put(parkingSpotNumber, new ParkingSpot(parkingSpotNumber, areaId));
            parkingSpotNumber++;
        }
        return parkingSpotNumber;
    }

    public boolean takeParkingSpot(int parkingSpotId) throws WrongParkingSpotNumberException {
        validate(parkingSpotId);
        ParkingSpot parkingSpot = freeParkingSpots.get(parkingSpotId);
        if (parkingSpot != null && parkingSpot.take()) {
            freeParkingSpots.remove(parkingSpotId);
            unpaidParkingSpots.put(parkingSpotId, parkingSpot);
            return true;
        }
        return false;
    }

    public boolean releaseParkingSpot(int parkingSpotId) throws WrongParkingSpotNumberException {
        validate(parkingSpotId);
        ParkingSpot parkingSpot = paidParkingSpots.get(parkingSpotId);
        if (parkingSpot != null) {
            if (parkingSpot.release()) {
                paidParkingSpots.remove(parkingSpotId);
                freeParkingSpots.put(parkingSpotId, parkingSpot);
                return true;
            }
        }
        else {
            parkingSpot = unpaidParkingSpots.get(parkingSpotId);
            if (parkingSpot != null && parkingSpot.release()) {
                unpaidParkingSpots.remove(parkingSpotId);
                freeParkingSpots.put(parkingSpotId, parkingSpot);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean payForParkingSpot(int parkingSpotId, LocalDateTime timeOfTicketExpiration) throws WrongParkingSpotNumberException {
        validate(parkingSpotId);
        ParkingSpot parkingSpot = unpaidParkingSpots.get(parkingSpotId);
        if (parkingSpot != null && parkingSpot.pay(LocalDateTime.now(), timeOfTicketExpiration)) {
            unpaidParkingSpots.remove(parkingSpotId);
            paidParkingSpots.put(parkingSpotId, parkingSpot);
            return true;
        }
        return false;
    }

    private void validate(int parkingSpot) throws WrongParkingSpotNumberException {
        if (parkingSpot < 1 || parkingSpot > NUMBER_OF_PARKING_SPOTS) {
            throw new WrongParkingSpotNumberException();
        }
    }
}
