package pl.basistam.soa.main.security.users;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsersDAO {

    @PersistenceContext(name = "parkomat")
    private EntityManager entityManager;

    public boolean validateUser(String id, String password) {
        User user = entityManager.find(User.class, id);
        return (user != null) && user.getPassword().equals(password);
    }

    public boolean changePassword(String id, String newPassword) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setPassword(newPassword);
            entityManager.merge(user);
            return true;
        }
        return false;
    }

    public boolean changePassword(String id, String oldPassword, String newPassword) {
        User user = entityManager.find(User.class, id);
        if (user != null && !user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            entityManager.merge(user);
            return true;
        }
        return false;
    }
}
