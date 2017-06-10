package pl.basistam.soa.main.api.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/find")
@ApplicationPath("/api")
public class NotificationRestApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getNotifications( ) {
        return "HEllo";
    }
}