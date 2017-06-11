package pl.basistam.dataAccess.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parking implements Serializable {
    public Parking(ParkingSpot parkingSpot, LocalDateTime timeOfParking) {
        this.parkingSpot = parkingSpot;
        this.timeOfParking = timeOfParking;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private ParkingSpot parkingSpot;
    private LocalDateTime timeOfParking;

}
