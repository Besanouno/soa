package pl.basistam.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.basistam.jms.JMSMessageSender;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageSenderBean {
    private String message;
    private String receiver;

    @Inject
    private JMSMessageSender sender;

    public String send(String subject) {
        if (receiver == null || receiver.trim().isEmpty()) {
            sender.sendToAll(subject, message);
        } else {
            sender.sendToOne(subject, receiver, message);
        }
        receiver = "";
        message = "";
        return "forum.xhtml";
    }
}
