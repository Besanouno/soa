package pl.basistam.service;

import pl.basistam.model.Book;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "library")
@ApplicationScoped
public class LibraryService implements Library, Serializable {

    @Inject
    private LibraryDAO libraryDAO;

    @Override
    public void save(Book book) {
        libraryDAO.save(book);
    }

    @Override
    public void delete(Long id) {
        libraryDAO.delete(id);
    }

    @Override
    public Book find(Long id) {
        return libraryDAO.find(id);
    }

    @Override
    public List<Book> getAll() {
        return libraryDAO.getAll();
    }
}
