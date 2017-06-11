package pl.basistam.soa.main.notificators;

import pl.basistam.dataAccess.common.NotificationType;
import pl.basistam.dataAccess.dto.NotificationDto;
import pl.basistam.dataAccess.util.LocalDateTimeConverter;
import pl.basistam.soa.main.carPark.CarPark;
import pl.basistam.soa.main.carPark.UnpaidParkingSpot;
import pl.basistam.soa.main.jms.MessageSender;

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
    private CarPark carPark;

    @Inject
    private MessageSender messageSender;

    private static final int UNPAID_PARKING_TIMEOUT_SEC = 120;

    private UnpaidParkingSpot firstUnpaidParkingSpot;
    private Timer timer;

    public void update() {
        findFirstUnpaidParking();
    }

    private void findFirstUnpaidParking() {
        Map.Entry<Integer, LocalDateTime> entry = carPark.getFirstUnpaidParkingSpot();
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
        if (firstUnpaidParkingSpot == null) {
            return;
        }
        NotificationDto notificationDTO = NotificationDto.builder()
                .area(carPark.getAreaForParkingSpot(firstUnpaidParkingSpot.getParkingSpotId()))
                .parkingSpot(firstUnpaidParkingSpot.getParkingSpotId())
                .time(firstUnpaidParkingSpot.getTimeOfParking())
                .type(NotificationType.UNPAID)
                .build();
        messageSender.send(notificationDTO.toJson());
        carPark.expireTimeToBuyTicket(firstUnpaidParkingSpot.getParkingSpotId(), firstUnpaidParkingSpot.getTimeOfParking());
        findFirstUnpaidParking();
    }

}
