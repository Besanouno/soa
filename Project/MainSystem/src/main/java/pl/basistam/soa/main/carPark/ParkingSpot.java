package pl.basistam.soa.main.carPark;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class ParkingSpot {
     public ParkingSpot(int id, int area) {
        this.id = id;
        this.area = area;
    }

    private int id;
    private int area;

}
