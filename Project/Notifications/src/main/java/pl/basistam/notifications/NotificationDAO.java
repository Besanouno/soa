package pl.basistam.notifications;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class NotificationDAO {

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
            predicates.add(criteriaBuilder.equal(rootQuery.get("area"), area));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

        TypedQuery<Notification> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
