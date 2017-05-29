package pl.basistam.soa.main.model;

import pl.basistam.soa.main.WrongParkingSpotNumberException;

import java.util.ArrayList;
import java.util.List;

class Area {

    private List<ParkingSpot> spots = new ArrayList<>();

    Area() {
        for (int i = 0; i < 40; i++) {
            spots.add(new ParkingSpot());
        }
    }

    public boolean takeParkingSpot(int parkingSpot) throws WrongParkingSpotNumberException {
        if (parkingSpot < 0 || parkingSpot >= spots.size()) {
            throw new WrongParkingSpotNumberException();
        }
        ParkingSpot spot = spots.get(parkingSpot);
        return spot.take();
    }
}
