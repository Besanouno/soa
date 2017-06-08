package pl.basistam.notifications.api.rest;


import pl.basistam.notifications.NotificationDAO;
import pl.basistam.notifications.NotificationDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Path("/find")
@ApplicationPath("/api")
public class NotificationRestApi {
    @Inject
    private NotificationDAO notificationDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NotificationDTO> getNotifications(@QueryParam("area") Integer area,
                                                  @QueryParam("start") String start,
                                                  @QueryParam("end") String end) {
        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = (end != null && !end.isEmpty()) ?
                LocalDateTime.parse(end) :
                null;
        return notificationDAO.getNotifications(startTime, endTime, area)
                .stream()
                .map(NotificationDTO::fromEntity)
                .collect(Collectors.toList());
    }
}