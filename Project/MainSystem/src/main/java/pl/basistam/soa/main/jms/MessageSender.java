package pl.basistam.soa.main.jms;


import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@ManagedBean
public class MessageSender {

    @Inject
    private JMSContext context;

    @Resource(mappedName = "java:jboss/exported/jms/queue/Company")
    private Queue queue;

    public void send(String text) { context.createProducer().send(queue, text); }
}
