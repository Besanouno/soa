package pl.basistam.dataAccess.api;

import pl.basistam.dataAccess.entities.Parking;
import pl.basistam.dataAccess.entities.ParkingSpot;
import pl.basistam.dataAccess.entities.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public interface CarParkDao {
    void saveTicket(Ticket ticket);

    void saveParking(Integer parkingSpotId, LocalDateTime timeOfParking);

    List<Ticket> getTicketsFromArea(int area, LocalDateTime beginning, LocalDateTime end);

    Long getParkingSpotNumber();

    ParkingSpot getParkingSpot(Integer id);

}
