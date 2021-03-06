package pl.basistam.receiver;

import pl.basistam.jms.JMSMessageProperties;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "QueueReceiver", activationConfig = {@ActivationConfigProperty(propertyName =
        "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName =
                "destination", propertyValue = "java:jboss/exported/jms/queue/ThematicList"),
        @ActivationConfigProperty(propertyName =
                "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class QueueReceiver implements MessageListener {
    @Inject
    private Users users;

    @Override
    public void onMessage(Message message) {
        for (User user : users.getUsers()) {
            try {
                String receiver = message.getStringProperty(JMSMessageProperties.RECEIVER);
                if (user.getName().equals(receiver)
                        && user.shouldReceive(message.getStringProperty(JMSMessageProperties.SUBJECT))) {
                    System.out.println("user " + user.getName() + " received a message from queue: " + ((TextMessage) message).getText());
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}