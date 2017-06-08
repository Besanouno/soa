package pl.basistam.soa.main.carPark;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UnpaidParkingSpot {
    private int parkingSpotId;
    private LocalDateTime timeOfParking;
}