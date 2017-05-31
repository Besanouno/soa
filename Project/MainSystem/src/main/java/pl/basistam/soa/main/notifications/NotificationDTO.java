package pl.basistam.soa.main.notifications;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import pl.basistam.soa.main.util.LocalDateTimeAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDTO {
    private Long area;
    private Long parkingSpot;
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @Getter(AccessLevel.NONE)
    private LocalDateTime time;

    public Notification toEntity() {
        return Notification.builder()
                .time(this.time)
                .area(this.area)
                .parkingSpot(this.parkingSpot)
                .build();
    }

    public static NotificationDTO toDTO(Notification notification) {
        return NotificationDTO.builder()
                .time(notification.getTime())
                .area(notification.getArea())
                .parkingSpot(notification.getParkingSpot())
                .build();
    }
}
