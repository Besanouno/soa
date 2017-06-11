package pl.basistam.soa.main.carPark;


import pl.basistam.dataAccess.api.CarParkDao;
import pl.basistam.dataAccess.dto.TicketDto;
import pl.basistam.dataAccess.entities.Ticket;
import pl.basistam.soa.main.EjbBindings;
import pl.basistam.soa.main.WrongParkingSpotNumberException;
import pl.basistam.soa.main.notificators.TicketsExpirationNotifier;
import pl.basistam.soa.main.notificators.UnpaidParkingNotifier;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
public class TicketAssignmentController {

    @Inject
    private CarPark carPark;

    @EJB(mappedName = EjbBindings.CarParkDao_JNDI)
    private CarParkDao carParkDAO;

    @Inject
    private TicketsExpirationNotifier ticketsExpirationNotifier;

    @Inject
    private UnpaidParkingNotifier unpaidParkingNotifier;


    public boolean saveTicket(TicketDto ticketDTO) throws WrongParkingSpotNumberException {
        Ticket ticket = ticketDTO.toEntity();

        if (carPark.payForParkingSpot(ticketDTO.getParkingSpotId(), ticket)) {
            carParkDAO.saveTicket(ticket);
            unpaidParkingNotifier.update();
            ticketsExpirationNotifier.update();
            return true;
        }
        return false;
    }
}
