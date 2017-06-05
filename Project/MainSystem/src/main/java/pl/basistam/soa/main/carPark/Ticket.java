package pl.basistam.soa.main.carPark;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;
    private int parkingSpotId;
    private Long parkingMeterId;
    private LocalDateTime timeOfPurchase;
    private LocalDateTime timeOfExpiration;

}
