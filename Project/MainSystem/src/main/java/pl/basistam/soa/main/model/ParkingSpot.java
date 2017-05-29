package pl.basistam.soa.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpot {
    private boolean available;
    private LocalDateTime timeOfParking;
    private LocalDateTime timeOfTicketPurchase;
    private LocalDateTime timeOfTicketExpiration;
}
