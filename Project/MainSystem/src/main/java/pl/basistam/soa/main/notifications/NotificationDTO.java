package pl.basistam.soa.main.notifications;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private int area;
    private int parkingSpot;
    private String type;
    @JsonSerialize(using = ToStringSerializer.class)
    @Getter(AccessLevel.NONE)
    private LocalDateTime time;


    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.out.println("Error in parsing notification to json");
            return "";
        }
    }
}
