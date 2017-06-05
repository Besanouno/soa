package pl.basistam.soa.main.notificators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.basistam.soa.main.carPark.Parking;
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

    @Getter
    @AllArgsConstructor
    private class UnpaidParkingSpot {
        private int parkingSpotId;
        private LocalDateTime timeOfParking;
    }

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
                LocalDateTimeConverter.toDate(firstUnpaidParkingSpot.getTimeOfParking().plusSeconds(30)),
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
        System.out.println("Bilet nie został kupiony");
        parking.expireTimeToBuyTicket(firstUnpaidParkingSpot.getParkingSpotId());
        findFirstUnpaidParking();
    }

}
