package pl.basistam.soa.main.carPark;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
class ParkingSpot {
    private boolean available = true;
    private LocalDateTime timeOfParking;
    private LocalDateTime timeOfTicketPurchase;
    private LocalDateTime timeOfTicketExpiration;

    public boolean take() {
        if (!available) {
            return false;
        }
        available = false;
        timeOfParking = LocalDateTime.now();
        return true;
    }

    public boolean release() {
        available = true;
        timeOfParking = null;
        timeOfTicketExpiration = null;
        timeOfTicketPurchase = null;
        return true;
    }
}
