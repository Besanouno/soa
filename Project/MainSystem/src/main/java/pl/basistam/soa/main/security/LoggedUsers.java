package pl.basistam.soa.main.security;

import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
@Singleton
public class LoggedUsers {
    private Set<String> users = new HashSet<>();

    public void login(String user) {
        users.add(user);
    }

    public void logout(String user) {
        users.remove(user);
    }

    public boolean isLogged(String user) {
        return  users.contains(user);
    }
}
