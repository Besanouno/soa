package pl.basistam.service;

import pl.basistam.model.Book;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class LibraryDAO {

    @PersistenceContext(name = "books")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(Book book) {
        if (book.getId() != null) {
            entityManager.merge(book);
        } else {
            entityManager.persist(book);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(Long id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
    }

    public Book find(Long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> rootQuery = criteriaQuery.from(Book.class);
        criteriaQuery.select(rootQuery);
        TypedQuery<Book> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
