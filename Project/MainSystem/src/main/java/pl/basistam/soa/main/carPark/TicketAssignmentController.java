package pl.basistam.soa.main.carPark;


import pl.basistam.soa.main.WrongParkingSpotNumberException;
import pl.basistam.soa.main.tickets.TicketDTO;

import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class TicketAssignmentController {

    @Inject
    private Parking parking;

    @Inject
    private ParkingDAO parkingDAO;

    public void saveTicket(TicketDTO ticket) throws WrongParkingSpotNumberException {
        if (parking.payForParkingSpot(ticket.getParkingSpotId(), ticket.getTimeOfExpiration())) {
            parkingDAO.saveTicket(ticket.toEntity());
        }
    }
}
