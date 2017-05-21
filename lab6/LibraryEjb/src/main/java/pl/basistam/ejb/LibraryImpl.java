package pl.basistam.ejb;

import pl.basistam.books.Book;
import pl.basistam.books.BooksRegister;
import pl.basistam.books.State;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;

@Singleton
@Remote(Library.class)
public class LibraryImpl implements Library {
    private List<Book> books;
    private BooksRegister register = new BooksRegister();

    @PostConstruct
    private void loadBooks() {
        books = register.loadBooks();
    }

    @Override
    @Lock(WRITE)
    public void changeBookState(String isbn, State state) {
        books.stream()
                .filter(b -> Objects.equals(b.getIsbn(), isbn))
                .forEach(b -> b.setState(state));
        register.saveBooks(books);
    }

    @Override
    @Lock(READ)
    public List<Book> getBooks(State state) {
        return books.stream().filter(b -> b.getState() == state).collect(Collectors.toList());
    }

    @Override
    @Lock(WRITE)
    public void addBook(Book book) {
        books.add(book);
        register.saveBooks(books);
    }
}
