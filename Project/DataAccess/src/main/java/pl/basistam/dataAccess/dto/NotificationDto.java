package pl.basistam.dataAccess.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.*;
import pl.basistam.dataAccess.entities.Notification;
import pl.basistam.dataAccess.util.LocalDateTimeAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDto {
    private int area;
    private int parkingSpot;
    private String type;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @Getter(AccessLevel.NONE)
    private LocalDateTime time;

    public Notification toEntity() {
        return Notification.builder()
                .time(this.time)
                .area(this.area)
                .parkingSpot(this.parkingSpot)
                .type(this.type)
                .build();
    }

    public static NotificationDto fromEntity(Notification entity) {
        return NotificationDto.builder()
                .time(entity.getTime())
                .area(entity.getArea())
                .parkingSpot(entity.getParkingSpot())
                .type(entity.getType())
                .build();
    }

    public static NotificationDto fromJson(String text) {
        System.out.println(text);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(text, NotificationDto.class);
        } catch (IOException e) {
            return NotificationDto.builder().build();
        }
    }
}
