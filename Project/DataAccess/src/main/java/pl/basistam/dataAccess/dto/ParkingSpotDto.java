package pl.basistam.dataAccess.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.basistam.dataAccess.entities.ParkingSpot;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingSpotDto {
    private Integer id;
    private Integer area;

    public static ParkingSpotDto fromEntity(ParkingSpot parkingSpot) {
        return ParkingSpotDto.builder()
                .id(parkingSpot.getId())
                .area(parkingSpot.getArea())
                .build();
    }

    public ParkingSpot toEntity() {
        return ParkingSpot.builder()
                .id(this.id)
                .area(this.area)
                .build();
    }
}
