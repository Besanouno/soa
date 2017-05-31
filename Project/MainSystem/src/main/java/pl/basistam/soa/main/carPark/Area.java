package pl.basistam.soa.main.carPark;

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
        validateParkingSpot(parkingSpot);
        return spots.get(parkingSpot).take();
    }

    public boolean releaseParkingSpot(int parkingSpot) throws WrongParkingSpotNumberException {
        validateParkingSpot(parkingSpot);
        return spots.get(parkingSpot).release();
    }

    private void validateParkingSpot(int parkingSpot) throws WrongParkingSpotNumberException {
        if (parkingSpot < 0 || parkingSpot >= spots.size()) {
            throw new WrongParkingSpotNumberException();
        }
    }

}