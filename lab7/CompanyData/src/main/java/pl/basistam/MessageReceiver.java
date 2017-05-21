package pl.basistam;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@ManagedBean
@SessionScoped
@MessageDriven(name = "MDBService", activationConfig = {@ActivationConfigProperty(propertyName =
        "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName =
                "destination", propertyValue = "java:jboss/exported/jms/queue/Company"),
        @ActivationConfigProperty(propertyName =
                "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class MessageReceiver implements MessageListener {

    @ManagedProperty("#{register}")
    private CompanyRegister register;

    public void setRegister(CompanyRegister register) {
        this.register = register;
    }

    @PostConstruct
    private void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        register = context.getApplication().evaluateExpressionGet(context, "#{register}", CompanyRegister.class);
    }

    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            register.add(tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
