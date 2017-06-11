package pl.basistam.soa.main.security;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class CurrentSession implements Serializable {
    private String currentUserId;

    public void setUser(String user) {
        this.currentUserId = user;
    }

    public String getCurrentUserId() {
        return this.currentUserId;
    }
}
