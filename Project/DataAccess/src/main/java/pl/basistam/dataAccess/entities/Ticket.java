package pl.basistam.dataAccess.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ejb.Remote;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tickets")
@Remote(Ticket.class)
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private ParkingSpot parkingSpot;
    private Long parkingMeterId;
    private LocalDateTime timeOfPurchase;
    private LocalDateTime timeOfExpiration;

}
