package pl.basistam.dataAccess.dao;

import pl.basistam.dataAccess.api.NotificationDao;
import pl.basistam.dataAccess.entities.Notification;
import pl.basistam.dataAccess.entities.ParkingSpot;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote(NotificationDao.class)
public class NotificationDaoImpl implements NotificationDao {

    @PersistenceContext(name = "parkomat")
    private EntityManager entityManager;

    public void saveNotification(Notification notification) {
        entityManager.persist(notification);
    }

    public List<Notification> getNotifications(LocalDateTime start, LocalDateTime end, Integer area) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Notification> criteriaQuery = criteriaBuilder.createQuery(Notification.class);
        Root<Notification> rootQuery = criteriaQuery.from(Notification.class);
        criteriaQuery.select(rootQuery);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.greaterThanOrEqualTo(rootQuery.get("time"), start));
        if (end != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(rootQuery.get("time"), end));
        }
        if (area != null) {
            Join<Notification, ParkingSpot> join = rootQuery.join("parkingSpot");
            predicates.add(criteriaBuilder.equal(join.get("area"), area));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

        TypedQuery<Notification> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
