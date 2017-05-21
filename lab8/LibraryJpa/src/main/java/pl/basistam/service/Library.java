package pl.basistam.service;

import pl.basistam.model.Book;

import java.util.Collection;
import java.util.List;

public interface Library {
    void save(Book book);
    void delete(Long id);
    Book find(Long id);
    List<Book> getAll();
}
