package pl.basistma.receiver;

import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Model
public class Users implements Serializable {
    private List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public List<User> getAll() {
        return users;
    }
}
