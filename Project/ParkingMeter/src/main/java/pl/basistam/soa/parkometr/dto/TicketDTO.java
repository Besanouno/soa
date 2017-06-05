package pl.basistam.soa.parkometr.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ws.rs.ext.MessageBodyWriter;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO implements Serializable {
    private int parkingSpotId;
    private Long parkingMeterId;
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime timeOfPurchase;
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime timeOfExpiration;

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }
}
