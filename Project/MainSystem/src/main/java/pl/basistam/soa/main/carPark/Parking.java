package pl.basistam.soa.main.carPark;

import pl.basistam.soa.main.WrongParkingSpotNumberException;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class Parking {
    private List<Area> areas = new ArrayList<>();

    public Parking() {
        areas.add(new Area());
        areas.add(new Area());
        areas.add(new Area());
        areas.add(new Area());
    }

    public boolean takeParkingSpot(int area, int parkingSpot) throws WrongParkingSpotNumberException {
        validateArea(area);
        return areas.get(area).takeParkingSpot(parkingSpot);
    }

    public boolean releaseParkingSpot(int area, int parkingSpot) throws WrongParkingSpotNumberException {
        validateArea(area);
        return areas.get(area).releaseParkingSpot(parkingSpot);
    }

    private void validateArea(int area) throws WrongParkingSpotNumberException {
        if (area < 0 || area >= areas.size()) {
            throw new WrongParkingSpotNumberException();
        }
    }
}