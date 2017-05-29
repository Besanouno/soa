package pl.basistam.soa.parkometr.dto;

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
    private Long parkometrId;
    private LocalDateTime timeOfPurchase;
    private LocalDateTime timeOfExpiration;
}
