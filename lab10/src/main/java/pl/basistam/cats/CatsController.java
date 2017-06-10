package pl.basistam.cats;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/cats")
@ApplicationPath("/resources")
public class CatsController {
    @GET
    public String getCats() {
        return "KURWA";
    }
}
