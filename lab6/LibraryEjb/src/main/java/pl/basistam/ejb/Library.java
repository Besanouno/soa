package pl.basistam.ejb;

import pl.basistam.books.Book;
import pl.basistam.books.State;

import java.util.List;

public interface Library {
    void changeBookState(String isbn, State state);
    List<Book> getBooks(State state);
    void addBook(Book book);
}
