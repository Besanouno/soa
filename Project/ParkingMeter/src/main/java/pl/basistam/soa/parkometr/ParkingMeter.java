package pl.basistam.soa.parkometr;

import com.fasterxml.jackson.core.JsonProcessingException;
import pl.basistam.soa.parkometr.dto.TicketDTO;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ParkingMeter {
    private Scanner scanner = new Scanner(System.in);

    public boolean buyTicket() throws JsonProcessingException {
        TicketDTO ticket = enterTicketData();
        Response response = ClientBuilder.newClient()
                .target("http://localhost:8080/mainApp/api/tickets/add")
                .request()
                .post(Entity.json(ticket.toJson()));
        return response.getStatus() == 200;
    }

    private TicketDTO enterTicketData() {
        System.out.println("Numer parkometru: ");
        Long parkingMeterId = scanner.nextLong();
        System.out.println("Numer miejsca:");
        int parkingSpotId = scanner.nextInt();
        System.out.println("Czas trwania (minuty): ");
        long minutes = scanner.nextLong();
        LocalDateTime expiration = LocalDateTime
                .now()
                .plusMinutes(minutes);

        return TicketDTO.builder()
                .parkingMeterId(parkingMeterId)
                .parkingSpotId(parkingSpotId)
                .timeOfExpiration(expiration)
                .timeOfPurchase(LocalDateTime.now())
                .build();
    }
}
