package pl.basistam.soa.parkometr.dto;

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
    private Long parkometrId;
    private LocalDateTime timeOfPurchase;
    private LocalDateTime timeOfExpiration;
}
