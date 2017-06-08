package pl.basistam.notifications;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
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
public class NotificationsListener implements MessageListener {

    @Inject
    private NotificationDAO notificationDAO;

    @Override
    public void onMessage(Message message) {
        try {
            NotificationDTO notificationDTO = NotificationDTO.fromJson(((TextMessage) message).getText());
            System.out.println(notificationDTO.getParkingSpot());
            Notification notification = notificationDTO.toEntity();
            notificationDAO.saveNotification(notification);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
