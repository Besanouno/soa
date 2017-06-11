package pl.basistam.soa.main.reports;

import com.itextpdf.text.DocumentException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

@Path("/reports")
@ApplicationPath("/api")
public class ReportController {
    @Inject
    private ReportEngine reportEngine;

    @GET
    @Path("/tickets")
    @Produces("application/pdf")
    public Response generateTicketsReport(@QueryParam("area") int area,
                                   @QueryParam("beginning") String beginning,
                                   @QueryParam("end") String end) {
        LocalDateTime beginningDate = LocalDateTime.parse(beginning);
        LocalDateTime endDate= LocalDateTime.parse(end);

        try {
            byte [] report = reportEngine.createTicketsRaport(area, beginningDate, endDate);
            return Response.ok(report).header(
                    "Content-Disposition", "attachment; filename=report.pdf"
            ).build();
        } catch (DocumentException e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}
