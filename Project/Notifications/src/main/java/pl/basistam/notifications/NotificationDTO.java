package pl.basistam.notifications;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.IOException;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDTO {
    private int area;
    private int parkingSpot;
    @Getter(AccessLevel.NONE)
    private LocalDateTime time;

    public static NotificationDTO fromJson(String text) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(text, NotificationDTO.class);
        } catch (IOException e) {
            return NotificationDTO.builder().build();
        }
    }
}
