package pl.basistam.soa.main.notificators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.basistam.soa.main.carPark.Parking;
import pl.basistam.soa.main.carPark.UnpaidParkingSpot;
import pl.basistam.soa.main.jms.MessageSender;
import pl.basistam.soa.main.notifications.NotificationDTO;
import pl.basistam.soa.main.util.LocalDateTimeConverter;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Map;

@Singleton
public class UnpaidParkingNotifier {
    @Resource
    private TimerService timerService;

    @Inject
    private Parking parking;

    @Inject
    private MessageSender messageSender;

    private static final int UNPAID_PARKING_TIMEOUT_SEC = 120;

    private UnpaidParkingSpot firstUnpaidParkingSpot;
    private Timer timer;

    public void update() {
        findFirstUnpaidParking();
    }

    private void findFirstUnpaidParking() {
        Map.Entry<Integer, LocalDateTime> entry = parking.getFirstUnpaidParkingSpot();
        if (entry != null) {
            firstUnpaidParkingSpot = new UnpaidParkingSpot(entry.getKey(), entry.getValue());
            setTimer();
        } else {
            cancelTimer();
        }
    }

    private void setTimer() {
        cancelTimer();
        timer = timerService.createSingleActionTimer(
                LocalDateTimeConverter.toDate(firstUnpaidParkingSpot.getTimeOfParking().plusSeconds(UNPAID_PARKING_TIMEOUT_SEC)),
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
    public void sendNotificationWhenTicketIsNotBought(Timer timer) {
        NotificationDTO notificationDTO = NotificationDTO.builder()
                .area(parking.getAreaForParkingSpot(firstUnpaidParkingSpot.getParkingSpotId()))
                .parkingSpot(firstUnpaidParkingSpot.getParkingSpotId())
                .time(firstUnpaidParkingSpot.getTimeOfParking())
                .build();
        messageSender.send(notificationDTO.toJson());
        parking.expireTimeToBuyTicket(firstUnpaidParkingSpot.getParkingSpotId(), firstUnpaidParkingSpot.getTimeOfParking());
        findFirstUnpaidParking();
    }

}
