package pl.basistam.soa.main.tickets;

import pl.basistam.soa.main.WrongParkingSpotNumberException;
import pl.basistam.soa.main.carPark.Parking;
import pl.basistam.soa.main.carPark.ParkingDAO;
import pl.basistam.soa.main.timer.ParkingTimer;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TicketAssignmentController {
    @Inject
    private Parking parking;

    @Inject
    private ParkingDAO parkingDAO;

    @Inject
    private ParkingTimer timer;

    public boolean saveTicket(TicketDTO ticket) {
        boolean paymentSuccess;
        try {
            paymentSuccess = parking.payForParkingSpot(ticket.getParkingSpotId(), ticket.getTimeOfExpiration());
        } catch (WrongParkingSpotNumberException e) {
            System.out.println(e.toString());
            return false;
        }
        if (paymentSuccess) {
            parkingDAO.saveTicket(ticket.toEntity());
//            timer.updateTimer(ticket.getTimeOfExpiration());
        }
        return paymentSuccess;
    }
}


