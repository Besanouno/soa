package pl.basistam;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.jms.*;

@ManagedBean
@SessionScoped
public class MessageSender {

    @Inject
    private JMSContext context;

    @Resource(mappedName = "java:jboss/exported/jms/queue/Company")
    private Queue queue; 

    public void send(String txt) {
        context.createProducer().send(queue, txt);
    }
}