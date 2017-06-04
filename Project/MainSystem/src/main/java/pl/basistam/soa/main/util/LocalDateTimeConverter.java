package pl.basistam.soa.main.util;

import javax.ejb.TimerConfig;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

public class LocalDateTimeConverter {

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(OffsetDateTime.now().getOffset()));
    }
}
