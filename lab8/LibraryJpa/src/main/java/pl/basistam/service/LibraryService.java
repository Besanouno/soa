package pl.basistam.service;

import pl.basistam.model.Book;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

public class LibraryService implements Library {

    public void save(Book book) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("books");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            if (book.getId() != null) {
                entityManager.merge(book);
            } else {
                entityManager.persist(book);
            }
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    public void delete(Long id) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("books");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
            Book book = entityManager.find(Book.class, id);
            entityManager.remove(book);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    public Book find(Long id) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("books");
            entityManager = entityManagerFactory.createEntityManager();

            return entityManager.find(Book.class, id);

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    public List<Book> getAll() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("books");
            entityManager = entityManagerFactory.createEntityManager();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
            Root<Book> rootQuery = criteriaQuery.from(Book.class);
            criteriaQuery.select(rootQuery);
            TypedQuery<Book> query = entityManager.createQuery(criteriaQuery);
            List<Book> result = query.getResultList();
            return result;

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }

    }
}
