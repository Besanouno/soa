package pl.basistma.beans;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.*;

@ApplicationScoped
public class JMSMessageSender {
    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory cf;
    @Resource(mappedName = "java:jboss/exported/jms/queue/Library")
    private Queue queueExample;
    private Connection connection;

    public void send(String txt) {
        try {
            connection = cf.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(queueExample);
            connection.start();
            TextMessage message = session.createTextMessage(txt);
            publisher.send(message);
        }
        catch (Exception exc) {
            System.err.println("Błąd! "+exc);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                    connection = null;} catch (JMSException e) {
                    System.err.println(e); }
            }
        }
    }
}