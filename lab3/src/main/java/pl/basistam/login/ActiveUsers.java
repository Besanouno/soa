package pl.basistam.login;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ActiveUsers {
    private List<Session> sessions = new ArrayList<>();
    private UsersRepository repository = UsersRepository.getInstance();
    private AtomicInteger id = new AtomicInteger(1);
    private static ActiveUsers instance;

    public static ActiveUsers getInstance() {
        if (instance == null) {
            synchronized (ActiveUsers.class) {
                if (instance == null) {
                    instance = new ActiveUsers();
                }
            }
        }
        return instance;
    }

    private ActiveUsers() {}

    public int login(User user) {
        if (repository.exists(user)) {
            int id = this.id.getAndIncrement();
            sessions.add(new Session(id, user.getNick()));
            return id;
        }
        return -1;
    }

    public void logout(int id) {
        int i = 0;
        for(Session s: sessions) {
           if (s.getId() == id) {
               break;
           }
           i++;
        }
        sessions.remove(i);
    }

    public List<Session> getUsers() {
        return new ArrayList<>(sessions);
    }
}
