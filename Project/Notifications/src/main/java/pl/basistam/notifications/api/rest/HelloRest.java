package pl.basistam.notifications.api.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/hello")
@ApplicationPath("/api")
public class HelloRest {

    @GET
    public String hello() {
        return "Hello";
    }
}
