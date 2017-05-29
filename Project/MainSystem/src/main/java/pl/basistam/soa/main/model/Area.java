package pl.basistam.soa.main.model;

import pl.basistam.soa.main.WrongParkingSpotNumberException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Area {
    private List<ParkingSpot> spots = new ArrayList<>();

    public boolean takeParkingSpot(int parkingSpot) throws WrongParkingSpotNumberException {
        if (parkingSpot < 0 || parkingSpot >= spots.size()) {
            throw new WrongParkingSpotNumberException();
        }
        ParkingSpot spot = spots.get(parkingSpot);
        if (spot.isAvailable()) {
            spot.setAvailable(false);
            spot.setTimeOfParking(LocalDateTime.now());
            return true;
        }
        return false;
    }
}
