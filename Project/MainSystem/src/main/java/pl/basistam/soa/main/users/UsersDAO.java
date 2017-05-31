package pl.basistam.soa.main.users;

import pl.basistam.soa.main.users.User;

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

}
