package pl.basistam.ejb;

import pl.basistam.books.Book;
import pl.basistam.books.State;

import java.util.List;

public interface Library {
    void changeBookState(Long id, State state);
    List<Book> getBooks(State state);
}
