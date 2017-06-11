package pl.basistam.soa.main.carPark;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int parkingSpotId;
    private Long parkingMeterId;
    private LocalDateTime timeOfPurchase;
    private LocalDateTime timeOfExpiration;

}
