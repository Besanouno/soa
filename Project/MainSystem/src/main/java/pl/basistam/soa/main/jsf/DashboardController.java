package pl.basistam.soa.main.jsf;

import pl.basistam.dataAccess.dto.TicketDto;
import pl.basistam.soa.main.carPark.CarPark;
import pl.basistam.soa.main.carPark.UnpaidParkingSpot;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
public class DashboardController {
    @Inject
    private CarPark carPark;

    public List<UnpaidParkingSpot> getUnpaidParkingSpots(int area) {
        return carPark.getUnpaidParkingSpots()
                .entrySet()
                .stream()
                .filter(e -> area == carPark.getAreaForParkingSpot(e.getKey()))
                .map(e -> new UnpaidParkingSpot(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public List<TicketDto> getPaidParkingSpots(int area) {
        return carPark.getPaidParkingSpots()
                .entrySet()
                .stream()
                .filter(e -> area == carPark.getAreaForParkingSpot(e.getKey()))
                .map(e -> TicketDto.fromEntity(e.getValue()))
                .collect(Collectors.toList());
    }

    public List<UnpaidParkingSpot> getExpiredParkingSpots(int area) {
        return carPark.getExpiredParkingSpots()
                .entrySet()
                .stream()
                .filter(e -> area == carPark.getAreaForParkingSpot(e.getKey()))
                .map(e -> new UnpaidParkingSpot(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public void hello() {
        System.out.println("SIEMA");
    }
}
