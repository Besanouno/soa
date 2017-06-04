package pl.basistam.soa.main.notificators;

import pl.basistam.soa.main.carPark.Parking;
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

    private LocalDateTime nextTicketTimeExpiration;

    public void update(LocalDateTime ticketExpiration) {
        if (nextTicketTimeExpiration == null || ticketExpiration.isBefore(nextTicketTimeExpiration)) {
            this.nextTicketTimeExpiration = ticketExpiration;

            timerService.createSingleActionTimer(
                    LocalDateTimeConverter.toDate(ticketExpiration.plusMinutes(2)),
                    new TimerConfig());
        }
    }

    @Timeout
    public void sendNotificationWhenTicketExpire(Timer timer) {
        System.out.println("BILET WYGASŁ");
    }
}
