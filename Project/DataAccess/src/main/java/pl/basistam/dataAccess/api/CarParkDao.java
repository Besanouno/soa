package pl.basistam.dataAccess.api;

import pl.basistam.dataAccess.entities.Parking;
import pl.basistam.dataAccess.entities.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public interface CarParkDao {
    public void saveTicket(Ticket ticket);

    public void saveParking(Parking parking);

    public List<Ticket> getTicketsFromArea(int area, LocalDateTime beginning, LocalDateTime end);
}
