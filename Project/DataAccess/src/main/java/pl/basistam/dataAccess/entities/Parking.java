package pl.basistam.dataAccess.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parking implements Serializable {
    public Parking(int parkingSpotId, LocalDateTime timeOfParking) {
        this.parkingSpotId = parkingSpotId;
        this.timeOfParking = timeOfParking;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int parkingSpotId;
    private LocalDateTime timeOfParking;

}
