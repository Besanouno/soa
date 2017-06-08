package pl.basistam.soa.main.carPark.xml;

import java.util.HashMap;
import java.util.Map;

public class CarParkLayout {
    private Map<Integer, Integer> carPark = new HashMap<>();

    public CarParkLayout() {
        Areas areas = new AreasReader().getAreas();
        for (Area area: areas.getAreas()) {
            for (Integer parkingSpot : area.getSpots()) {
                carPark.put(parkingSpot, area.getId());
            }
        }
    }

    public int getAreaForParkingSpot(int parkingSpot) {
        return carPark.get(parkingSpot);
    }

    public int getParkingSpotsNumber() {
        return carPark.size();
    }
}
