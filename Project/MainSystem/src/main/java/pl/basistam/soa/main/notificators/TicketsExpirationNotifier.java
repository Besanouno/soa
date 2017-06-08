package pl.basistam.soa.main.notificators;

import pl.basistam.soa.main.carPark.Parking;
import pl.basistam.soa.main.carPark.Ticket;
import pl.basistam.soa.main.carPark.xml.CarParkLayout;
import pl.basistam.soa.main.jms.MessageSender;
import pl.basistam.soa.main.notifications.NotificationDTO;
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

    @Inject
    private MessageSender messageSender;

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
            // Nothing wrong, timer just expired and there is nothing to cancel.
        }
    }


    @Timeout
    public void sendNotificationWhenTicketExpire(Timer timer) {
        int parkingSpot = nextExpiringTicket.getParkingSpotId();

        NotificationDTO notificationDTO = NotificationDTO.builder()
                .area(parking.getAreaForParkingSpot(parkingSpot))
                .parkingSpot(parkingSpot)
                .time(nextExpiringTicket.getTimeOfExpiration())
                .build();
        messageSender.send(notificationDTO.toJson());
        parking.expireTicket(nextExpiringTicket.getParkingSpotId());
        findNextExpiringTicket();
    }

}
