package pl.basistam.notifications;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.*;
import pl.basistam.notifications.util.LocalDateTimeAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDTO {
    private int area;
    private int parkingSpot;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
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

    public static NotificationDTO fromEntity(Notification entity) {
        return NotificationDTO.builder()
                .time(entity.getTime())
                .area(entity.getArea())
                .parkingSpot(entity.getParkingSpot())
                .build();
    }

    public static NotificationDTO fromJson(String text) {
        System.out.println(text);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(text, NotificationDTO.class);
        } catch (IOException e) {
            return NotificationDTO.builder().build();
        }
    }
}
