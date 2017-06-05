package pl.basistam.soa.main.carPark;


import pl.basistam.soa.main.WrongParkingSpotNumberException;
import pl.basistam.soa.main.notificators.TicketsExpirationNotifier;
import pl.basistam.soa.main.tickets.Ticket;
import pl.basistam.soa.main.tickets.TicketDTO;

import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class TicketAssignmentController {

    @Inject
    private Parking parking;

    @Inject
    private ParkingDAO parkingDAO;

    @Inject
    private TicketsExpirationNotifier ticketsExpirationNotifier;

    public void saveTicket(TicketDTO ticketDTO) throws WrongParkingSpotNumberException {
        Ticket ticket = ticketDTO.toEntity();

        if (parking.payForParkingSpot(ticketDTO.getParkingSpotId(), ticket)) {
            parkingDAO.saveTicket(ticket);
            ticketsExpirationNotifier.update();
        }
    }
}
