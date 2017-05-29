package pl.basistam.soa.main.model;

import pl.basistam.soa.main.WrongParkingSpotNumberException;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class Parking {
    private List<Area> areas = new ArrayList<>();

    public boolean takeParkingSpot(int area, int parkingSpot) throws WrongParkingSpotNumberException {
        if (area < 0 || area >= areas.size()) {
            throw new WrongParkingSpotNumberException();
        }
        return areas.get(area).takeParkingSpot(parkingSpot);
    }
}
