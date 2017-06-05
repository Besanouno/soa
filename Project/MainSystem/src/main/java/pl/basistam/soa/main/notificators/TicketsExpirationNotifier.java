package pl.basistam.soa.main.notificators;

import pl.basistam.soa.main.carPark.Parking;
import pl.basistam.soa.main.tickets.Ticket;
import pl.basistam.soa.main.util.LocalDateTimeConverter;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import java.time.LocalDateTime;

@Singleton
public class TicketsExpirationNotifier {
    @Inject
    private Parking parking;

    @Resource
    private TimerService timerService;

    private Timer timer;
    private Ticket nextExpiringTicket;

    public void update() {
        findNextExpiringTicket();
    }

    private void findNextExpiringTicket() {
        nextExpiringTicket = parking.getNextExpiringTicket();
        if (nextExpiringTicket != null) {
            setTimer();
        }
    }

    private void setTimer() {
        cancelTimer();
        timer = timerService.createSingleActionTimer(
                LocalDateTimeConverter.toDate(nextExpiringTicket.getTimeOfExpiration().plusSeconds(60)),
                new TimerConfig());
    }

    private void cancelTimer() {
        if (timer != null) try {
            timer.cancel();
        } catch (NoSuchObjectLocalException e) {
            // Nothing wrong, timer just expired.
        }
    }


    @Timeout
    public void sendNotificationWhenTicketExpire(Timer timer) {
        System.out.println(LocalDateTime.now() + "BILET WYGASŁ DLA MIEJSCA: " + nextExpiringTicket.getParkingSpotId());
        parking.expireTicket(nextExpiringTicket.getParkingSpotId());
        findNextExpiringTicket();
    }

}
