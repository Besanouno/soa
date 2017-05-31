package pl.basistam.soa.main.carPark;

import pl.basistam.soa.main.tickets.Ticket;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ParkingDAO {

    @PersistenceContext(name = "parkomat")
    private EntityManager entityManager;

    public void saveTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }
}
