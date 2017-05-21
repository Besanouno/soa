package pl.basistam.receiver;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.util.ArrayList;
import java.util.List;

@Model
public class Users {
    private List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Przykładowe dane
        User marcin = new User("marcin");
        marcin.addSubject("sport");

        User grzesiek = new User("grzesiek");
        grzesiek.addSubject("sport");

        User magda = new User("magda");
        magda.addSubject("kosmetyki");

        users.add(marcin);
        users.add(magda);
        users.add(grzesiek);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
