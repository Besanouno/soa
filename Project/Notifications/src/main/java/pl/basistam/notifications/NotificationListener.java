package pl.basistam.notifications;

import pl.basistam.dataAccess.api.NotificationDao;
import pl.basistam.dataAccess.dto.NotificationDto;
import pl.basistam.dataAccess.entities.Notification;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "listener", activationConfig = {@ActivationConfigProperty(propertyName =
        "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName =
                "destination", propertyValue = "java:jboss/exported/jms/queue/Parkomat"),
        @ActivationConfigProperty(propertyName =
                "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class NotificationListener implements MessageListener {

    @EJB(mappedName = EjbBindings.NotificationDao_JNDI)
    private NotificationDao notificationDAO;

    @Override
    public void onMessage(Message message) {
        try {
            NotificationDto notificationDTO = NotificationDto.fromJson(((TextMessage) message).getText());
            System.out.println(notificationDTO.getParkingSpot());
            Notification notification = notificationDTO.toEntity();
            notificationDAO.saveNotification(notification);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}