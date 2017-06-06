package pl.basistam.soa.main.carPark.xml;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class CarParkLayout {
    private Map<Integer, Integer> carPark = new HashMap<>();

    @PostConstruct
    public void init() {
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
