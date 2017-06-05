package pl.basistam.soa.main.notificators;

import pl.basistam.soa.main.util.LocalDateTimeConverter;

import javax.annotation.Resource;
import javax.ejb.*;
import java.time.LocalDateTime;

@Singleton
public class UnpaidParkingNotifier {
    @Resource
    private TimerService timerService;

    private LocalDateTime firstUnpaidParking;

    public void update(LocalDateTime timeOfParking) {
        if (firstUnpaidParking == null || firstUnpaidParking.isAfter(timeOfParking)) {
            this.firstUnpaidParking = timeOfParking;

            timerService.createSingleActionTimer(
                    LocalDateTimeConverter.toDate(timeOfParking.plusMinutes(3)),
                    new TimerConfig());
        }
    }

    @Timeout
    public void hello(Timer timer) {
        System.out.println("Bilet nie został kupiony");
    }
}
