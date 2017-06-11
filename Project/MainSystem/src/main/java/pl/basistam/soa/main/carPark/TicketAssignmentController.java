package pl.basistam.soa.main.carPark;


import pl.basistam.soa.main.WrongParkingSpotNumberException;
import pl.basistam.soa.main.notificators.TicketsExpirationNotifier;
import pl.basistam.soa.main.notificators.UnpaidParkingNotifier;

import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class TicketAssignmentController {

    @Inject
    private CarPark carPark;

    @Inject
    private CarParkDAO carParkDAO;

    @Inject
    private TicketsExpirationNotifier ticketsExpirationNotifier;

    @Inject
    private UnpaidParkingNotifier unpaidParkingNotifier;


    public void saveTicket(TicketDTO ticketDTO) throws WrongParkingSpotNumberException {
        Ticket ticket = ticketDTO.toEntity();

        if (carPark.payForParkingSpot(ticketDTO.getParkingSpotId(), ticket)) {
            carParkDAO.saveTicket(ticket);
            unpaidParkingNotifier.update();
            ticketsExpirationNotifier.update();
        }
    }
}
