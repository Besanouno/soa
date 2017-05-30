package pl.basistam.soa.parkometr;

import com.fasterxml.jackson.core.JsonProcessingException;
import pl.basistam.soa.parkometr.dto.TicketDTO;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Parkometr {
    private Scanner scanner = new Scanner(System.in);

    public void buyTicket() throws JsonProcessingException {
        TicketDTO ticket = enterTicketData();
        ClientBuilder.newClient()
                .target("http://localhost:8080/mainApp/parking/tickets/add")
                .request()
                .post(Entity.json(ticket.toJson()));
    }

    private TicketDTO enterTicketData() {
        System.out.println("Numer parkometru: ");
        Long id = scanner.nextLong();
        System.out.println("Czas trwania (minuty): ");
        long minutes = scanner.nextLong();
        LocalDateTime expiration = LocalDateTime.now();
        expiration.plusMinutes(minutes);

        return TicketDTO.builder()
                .parkometrId(id)
                .timeOfExpiration(expiration)
                .timeOfPurchase(LocalDateTime.now())
                .build();
    }
}
