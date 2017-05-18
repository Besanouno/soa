package pl.basistam.login;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    private List<User> registeredUsers = new ArrayList<>();
    private static UsersRepository instance;

    public static UsersRepository getInstance() {
        if (instance == null) {
            synchronized (UsersRepository.class) {
                if (instance == null) {
                    instance = new UsersRepository();
                }
            }
        }
        return instance;
    }

    private UsersRepository() {
        registeredUsers.add(new User("marcin", "admin1"));
        registeredUsers.add(new User("adam", "pass"));
        registeredUsers.add(new User("jola", "123"));
        registeredUsers.add(new User("marta", "qwerty"));
        registeredUsers.add(new User("ania", "zxc"));
    }

    public boolean exists(User user) {
        return registeredUsers
                .stream()
                .anyMatch(user::verify);
    }
}

