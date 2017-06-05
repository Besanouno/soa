package pl.basistam.soa.main.carPark;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {
    private int parkingSpotId;
    private Long parkingMeterId;
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timeOfPurchase;

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timeOfExpiration;

    public Ticket toEntity() {
        return Ticket.builder()
                .parkingSpotId(this.parkingSpotId)
                .parkingMeterId(this.parkingMeterId)
                .timeOfPurchase(this.timeOfPurchase)
                .timeOfExpiration(this.timeOfExpiration)
                .build();
    }
}
