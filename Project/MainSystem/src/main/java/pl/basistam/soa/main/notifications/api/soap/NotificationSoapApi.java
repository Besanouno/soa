package pl.basistam.soa.main.notifications.api.soap;

import pl.basistam.soa.main.notifications.NotificationDAO;
import pl.basistam.soa.main.notifications.NotificationDTO;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@WebService
public class NotificationSoapApi {
    @Inject
    private NotificationDAO notificationDAO;

    @WebMethod
    public List<NotificationDTO> getNotifications(Integer area, String start, String end) {
        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);
        return notificationDAO.getNotifications(startTime, endTime, area)
                .stream()
                .map(NotificationDTO::toDTO)
                .collect(Collectors.toList());
    }
}
