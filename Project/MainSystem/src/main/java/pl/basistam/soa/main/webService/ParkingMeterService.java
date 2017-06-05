package pl.basistam.soa.main.webService;

import pl.basistam.soa.main.WrongParkingSpotNumberException;
import pl.basistam.soa.main.carPark.ParkingDAO;
import pl.basistam.soa.main.carPark.TicketAssignmentController;
import pl.basistam.soa.main.tickets.TicketDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tickets")
@ApplicationPath("api")
public class ParkingMeterService extends Application {

    @Inject
    private TicketAssignmentController ticketAssignmentController;

    @POST
    @Path("/saveTicket")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(TicketDTO ticket) {
        try {
            ticketAssignmentController.saveTicket(ticket);
        } catch (WrongParkingSpotNumberException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
