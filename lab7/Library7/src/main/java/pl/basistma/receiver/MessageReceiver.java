package pl.basistma.receiver;


import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "MessageReceiver", activationConfig = {@ActivationConfigProperty(propertyName =
        "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName =
                "destination", propertyValue = "java:jboss/exported/jms/queue/Library"),
        @ActivationConfigProperty(propertyName =
                "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class MessageReceiver implements MessageListener {
    @Inject
    private Users users;

    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            final String text = tm.getText();
            users.getAll()
                    .forEach((u) -> {
                        if (u.isSubscribe()) {
                            System.out.println(u.getName() + ": " + text);
                        }
                    });
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}