package pl.basistam.soa.main.jsf;

import pl.basistam.soa.main.carPark.Parking;
import pl.basistam.soa.main.carPark.TicketDTO;
import pl.basistam.soa.main.carPark.UnpaidParkingSpot;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
public class DashboardController {
    @Inject
    private Parking parking;

    public List<UnpaidParkingSpot> getUnpaidParkingSpots(int area) {
        return parking.getUnpaidParkingSpots()
                .entrySet()
                .stream()
                .filter(e -> area == parking.getAreaForParkingSpot(e.getKey()))
                .map(e -> new UnpaidParkingSpot(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public List<TicketDTO> getPaidParkingSpots(int area) {
        return parking.getPaidParkingSpots()
                .entrySet()
                .stream()
                .filter(e -> area == parking.getAreaForParkingSpot(e.getKey()))
                .map(e -> TicketDTO.fromEntity(e.getValue()))
                .collect(Collectors.toList());
    }

    public List<UnpaidParkingSpot> getExpiredParkingSpots(int area) {
        return parking.getExpiredParkingSpots()
                .entrySet()
                .stream()
                .filter(e -> area == parking.getAreaForParkingSpot(e.getKey()))
                .map(e -> new UnpaidParkingSpot(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public void hello() {
        System.out.println("SIEMA");
    }
}
