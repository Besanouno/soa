package pl.basistam.jms;

public interface MessageSender {
    void sendToAll(String subject, String message);
    void sendToOne(String subject, String receiver, String message);
}
