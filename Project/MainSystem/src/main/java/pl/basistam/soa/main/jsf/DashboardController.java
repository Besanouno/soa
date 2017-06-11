package pl.basistam.soa.main.jsf;

import pl.basistam.dataAccess.dto.TicketDto;
import pl.basistam.soa.main.carPark.CarPark;
import pl.basistam.soa.main.carPark.UnpaidParkingSpot;

import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
@SessionScoped
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

}
