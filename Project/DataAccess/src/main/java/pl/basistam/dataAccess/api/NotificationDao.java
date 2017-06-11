package pl.basistam.dataAccess.api;

import pl.basistam.dataAccess.entities.Notification;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationDao {

    public void saveNotification(Notification notification);

    public List<Notification> getNotifications(LocalDateTime start, LocalDateTime end, Integer area);
}
