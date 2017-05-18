package pl.basistam.login;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Session {
    private int id;
    private String nick;
    private LocalDateTime loginDateTime;

    public Session(int id, String nick) {
        this.id = id;
        this.nick = nick;
        this.loginDateTime = LocalDateTime.now();
    }

    public int getId() { return id; }

    public String getNick() {
        return nick;
    }

    public String getLoginDateTime() {
        return loginDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
