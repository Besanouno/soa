package pl.basistam.soa.main.notificators;

import pl.basistam.soa.main.carPark.CarPark;
import pl.basistam.soa.main.carPark.Ticket;
import pl.basistam.soa.main.jms.MessageSender;
import pl.basistam.soa.main.notifications.NotificationDTO;
import pl.basistam.soa.main.util.LocalDateTimeConverter;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;

@Singleton
public class TicketsExpirationNotifier {
    @Inject
    private CarPark carPark;

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
        nextExpiringTicket = carPark.getNextExpiringTicket();
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
                .area(carPark.getAreaForParkingSpot(parkingSpot))
                .parkingSpot(parkingSpot)
                .time(nextExpiringTicket.getTimeOfExpiration())
                .build();
        messageSender.send(notificationDTO.toJson());
        carPark.expireTicket(nextExpiringTicket.getParkingSpotId(), nextExpiringTicket.getTimeOfExpiration());
        findNextExpiringTicket();
    }

}
