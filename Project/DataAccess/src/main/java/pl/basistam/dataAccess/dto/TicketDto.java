package pl.basistam.dataAccess.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.basistam.dataAccess.entities.Ticket;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto {
    private Integer parkingSpotId;
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

    public static TicketDto fromEntity(Ticket ticket) {
        return TicketDto.builder()
                .parkingSpotId(ticket.getParkingSpotId())
                .parkingMeterId(ticket.getParkingMeterId())
                .timeOfPurchase(ticket.getTimeOfPurchase())
                .timeOfExpiration(ticket.getTimeOfExpiration())
                .build();
    }
}