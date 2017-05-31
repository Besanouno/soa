package pl.basistam.soa.main.carPark;

import pl.basistam.soa.main.WrongParkingSpotNumberException;

import javax.ejb.Singleton;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class Parking {
    private final int NUMBER_OF_PARKING_SPOTS;
    private Map<Integer, ParkingSpot> parkingSpots = new HashMap<>();

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
            parkingSpots.put(parkingSpotNumber, new ParkingSpot(parkingSpotNumber, areaId));
            parkingSpotNumber++;
        }
        return parkingSpotNumber;
    }

    public boolean takeParkingSpot(int parkingSpot) throws WrongParkingSpotNumberException {
        validate(parkingSpot);
        return parkingSpots.get(parkingSpot)
                .take();
    }

    public boolean releaseParkingSpot(int parkingSpot) throws WrongParkingSpotNumberException {
        validate(parkingSpot);
        return parkingSpots.get(parkingSpot)
                .release();
    }

    public boolean payForParkingSpot(int parkingSpot, LocalDateTime timeOfTicketExpiration) throws WrongParkingSpotNumberException {
        validate(parkingSpot);
        return parkingSpots.get(parkingSpot)
                .pay(LocalDateTime.now(), timeOfTicketExpiration);
    }

    private void validate(int parkingSpot) throws WrongParkingSpotNumberException {
        if (parkingSpot < 1 || parkingSpot > NUMBER_OF_PARKING_SPOTS) {
            throw new WrongParkingSpotNumberException();
        }
    }
}
