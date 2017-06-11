package pl.basistam.soa.main.carPark;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.Local;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class UnpaidParkingSpot {
    public UnpaidParkingSpot(int parkingSpotId, LocalDateTime timeOfParking) {
        this.parkingSpotId = parkingSpotId;
        this.timeOfParking = timeOfParking;
        this.printableTimeOfParking = timeOfParking.format(DATE_FORMATTER);
    }
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private int parkingSpotId;
    private LocalDateTime timeOfParking;
    private String printableTimeOfParking;
}