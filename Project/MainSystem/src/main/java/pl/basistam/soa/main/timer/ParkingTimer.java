package pl.basistam.soa.main.timer;

import lombok.Getter;
import pl.basistam.soa.main.carPark.Parking;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Stateless
public class ParkingTimer {
    @Resource
    private TimerService timerService;

    @Inject
    private Parking parking;

    @Getter
    private LocalDateTime earliestExpirationTimeOfTicket;

    public void updateTimer(LocalDateTime dateTime) {
        this.earliestExpirationTimeOfTicket = dateTime;
        timerService.createSingleActionTimer(convertLocalDateTimeToDate(dateTime), new TimerConfig());
    }

    @Timeout
    public void action(Timer timer) {
        System.out.println("GOWNO WITAM");
    }

    private Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        Date input = new Date();
        Instant instant = input.toInstant();
        Date output = Date.from(instant);
        return output;
    }
}
