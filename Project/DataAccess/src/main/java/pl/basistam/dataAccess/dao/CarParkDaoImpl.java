package pl.basistam.dataAccess.dao;

import pl.basistam.dataAccess.api.CarParkDao;
import pl.basistam.dataAccess.entities.Parking;
import pl.basistam.dataAccess.entities.ParkingSpot;
import pl.basistam.dataAccess.entities.Ticket;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Stateless(mappedName = "CarParkDao")
@Remote(CarParkDao.class)
public class CarParkDaoImpl implements CarParkDao {

    @PersistenceContext(name = "parkomat")
    private EntityManager entityManager;

    public void saveTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }

    public void saveParking(Integer parkingSpotId, LocalDateTime timeOfParking) {
        ParkingSpot parkingSpot = entityManager.find(ParkingSpot.class, parkingSpotId);
        Parking parking = new Parking(parkingSpot, timeOfParking);
        entityManager.persist(parking);
    }

    public List<Ticket> getTicketsFromArea(int area, LocalDateTime beginning, LocalDateTime end) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteriaQuery = criteriaBuilder.createQuery(Ticket.class);
        Root<Ticket> rootQuery = criteriaQuery.from(Ticket.class);
        criteriaQuery.select(rootQuery);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.greaterThanOrEqualTo(rootQuery.get("timeOfPurchase"), beginning));
        predicates.add(criteriaBuilder.lessThanOrEqualTo(rootQuery.get("timeOfPurchase"), end));
        Join<Ticket, ParkingSpot> join = rootQuery.join("parkingSpot");
        predicates.add(criteriaBuilder.equal(join.get("area"), area));

        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

        TypedQuery<Ticket> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public Long getParkingSpotNumber() {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(ParkingSpot.class)));
        return entityManager.createQuery(cq).getSingleResult();
    }

    public ParkingSpot getParkingSpot(Integer id) {
        return entityManager.find(ParkingSpot.class, id);
    }
}
