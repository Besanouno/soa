package pl.basistam.notifications.api.soap;

import pl.basistam.dataAccess.api.NotificationDao;
import pl.basistam.dataAccess.dto.NotificationDto;
import pl.basistam.notifications.DataAccessEjb;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@WebService
public class NotificationSoapApi {
    @EJB(mappedName = DataAccessEjb.JNDI)
    private NotificationDao notificationDAO;

    @WebMethod
    public List<NotificationDto> getNotifications(Integer area, String start, String end) {
        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);
        return notificationDAO.getNotifications(startTime, endTime, area)
                .stream()
                .map(NotificationDto::fromEntity)
                .collect(Collectors.toList());
    }
}
