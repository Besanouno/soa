package pl.basistam.dataAccess.dao;

import pl.basistam.dataAccess.api.UsersDao;
import pl.basistam.dataAccess.entities.AreaEmployee;
import pl.basistam.dataAccess.entities.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote(UsersDao.class)
public class UsersDaoImpl implements UsersDao {

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
        if (user != null && user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            entityManager.merge(user);
            return true;
        }
        return false;
    }

    @Override
    public int getAreaForUser(String id) {
        AreaEmployee areaEmployee = entityManager.find(AreaEmployee.class, id);
        return areaEmployee.getArea();
    }
}
