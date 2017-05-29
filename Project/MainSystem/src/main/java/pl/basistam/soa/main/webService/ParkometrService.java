package pl.basistam.soa.main.webService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("/tickets")
@ApplicationPath("parking")
public class ParkometrService extends Application {
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String saveTicket() {
        return "Hello";
    }
}
