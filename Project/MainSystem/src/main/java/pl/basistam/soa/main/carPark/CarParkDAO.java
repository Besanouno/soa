package pl.basistam.soa.main.carPark;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarParkDAO {

    @PersistenceContext(name = "parkomat")
    private EntityManager entityManager;

    public void saveTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }

    public void saveParking(Parking parking) { entityManager.persist(parking); }
}
