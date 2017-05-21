package pl.basistam.jms;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.faces.bean.SessionScoped;
import javax.jms.*;

@ManagedBean
@SessionScoped
public class JMSMessageSender implements MessageSender {

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "java:jboss/exported/jms/topic/ThematicList")
    private Topic topic;

    @Resource(mappedName = "java:jboss/exported/jms/queue/ThematicList")
    private Queue queue;

    @Override
    public void sendToAll(String subject, String text) {
        send(topic, subject, null, text);
    }

    @Override
    public void sendToOne(String subject, String receiver, String text) {
        send(queue, subject, receiver, text);
    }

    private void send(Destination destination, String subject, String receiver, String text) {
        try (Connection connection = connectionFactory.createConnection()) {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(destination);

            connection.start();
            TextMessage message = session.createTextMessage(text);
            message.setStringProperty(JMSMessageProperties.RECEIVER, receiver);
            message.setStringProperty(JMSMessageProperties.SUBJECT, subject);

            publisher.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
