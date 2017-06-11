package pl.basistam.dataAccess.dao;

import pl.basistam.dataAccess.api.CarParkDao;
import pl.basistam.dataAccess.entities.Parking;
import pl.basistam.dataAccess.entities.Ticket;

import javax.ejb.Remote;
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
@Remote(CarParkDao.class)
public class CarParkDaoImpl implements CarParkDao {

    @PersistenceContext(name = "parkomat")
    private EntityManager entityManager;

    public void saveTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }

    public void saveParking(Parking parking) { entityManager.persist(parking); }

    public List<Ticket> getTicketsFromArea(int area, LocalDateTime beginning, LocalDateTime end) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteriaQuery = criteriaBuilder.createQuery(Ticket.class);
        Root<Ticket> rootQuery = criteriaQuery.from(Ticket.class);
        criteriaQuery.select(rootQuery);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.greaterThanOrEqualTo(rootQuery.get("timeOfPurchase"), beginning));
        predicates.add(criteriaBuilder.lessThanOrEqualTo(rootQuery.get("timeOfPurchase"), end));
        predicates.add(criteriaBuilder.equal(rootQuery.get("area"), area));

        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

        TypedQuery<Ticket> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
