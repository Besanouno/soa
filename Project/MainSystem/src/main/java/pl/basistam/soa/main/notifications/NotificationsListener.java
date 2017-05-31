package pl.basistam.soa.main.notifications;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

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
            NotificationDTO notificationDTO = message.getBody(NotificationDTO.class);
            Notification notification = notificationDTO.toEntity();
            notificationDAO.saveNotification(notification);
            System.out.println(notification);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
