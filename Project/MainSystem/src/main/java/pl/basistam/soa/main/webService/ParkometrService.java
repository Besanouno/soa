package pl.basistam.soa.main.webService;

import pl.basistam.soa.main.dao.ParkingDAO;
import pl.basistam.soa.main.dto.TicketDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("/tickets")
@ApplicationPath("parking")
public class ParkometrService extends Application {
    @Inject
    private ParkingDAO parkingDAO;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String saveTicket() {
        return "Hello";
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String add(TicketDTO ticket) {
        parkingDAO.saveTicket(ticket.toEntity());
        return ticket.toString();
    }
}
