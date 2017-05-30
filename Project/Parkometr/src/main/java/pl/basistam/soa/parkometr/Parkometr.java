package pl.basistam.soa.parkometr;

import pl.basistam.soa.parkometr.dto.TicketDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Parkometr {
    private Scanner scanner = new Scanner(System.in);

    public void buyTicket() {
        System.out.println("Numer parkometru: ");
        Long id = scanner.nextLong();
        System.out.println("Czas trwania (minuty): ");
        long minutes = scanner.nextLong();
        LocalDateTime expiration = LocalDateTime.now();
        expiration.plusMinutes(minutes);
        TicketDTO ticketDTO = TicketDTO.builder()
                .parkometrId(id)
                .timeOfExpiration(expiration)
                .timeOfPurchase(LocalDateTime.now())
                .build();

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/mainApp/parking/tickets/add");
        Response response = target.request().post(Entity.json(ticketDTO));
    }
}
