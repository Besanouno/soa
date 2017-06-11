package pl.basistam.notifications.api.rest;

import pl.basistam.dataAccess.api.NotificationDao;
import pl.basistam.dataAccess.dto.NotificationDto;
import pl.basistam.notifications.EjbBindings;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Path("/api")
public class NotificationRestApi {

    @EJB(mappedName = EjbBindings.NotificationDao_JNDI)
    private NotificationDao notificationDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NotificationDto> getNotifications(@QueryParam("area") Integer area,
                                                  @QueryParam("start") String start,
                                                  @QueryParam("end") String end) {
        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = (end != null && !end.isEmpty()) ?
                LocalDateTime.parse(end) :
                null;
        return notificationDAO.getNotifications(startTime, endTime, area)
                .stream()
                .map(NotificationDto::fromEntity)
                .collect(Collectors.toList());
    }
}