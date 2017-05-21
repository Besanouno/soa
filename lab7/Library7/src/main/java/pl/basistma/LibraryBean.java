package pl.basistma;

import pl.basistma.beans.JMSMessageSender;
import pl.basistam.books.Book;
import pl.basistam.books.State;
import pl.basistam.ejb.Library;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.List;

@ManagedBean(name = "libraryBean")
@ApplicationScoped
public class LibraryBean {
    private Library library;

    @Inject
    private JMSMessageSender sender;

    public void setSender(JMSMessageSender sender) {
        this.sender = sender;
    }

    public LibraryBean() throws NamingException {
        this.library = lookupLibraryEjb();
    }

    public List<Book> getReservedBooks() {
        return library.getBooks(State.RESERVED);
    }

    public List<Book> getLoanedBooks() {
        return library.getBooks(State.LOANED);
    }

    public List<Book> getIdleBooks() {
        return library.getBooks(State.IDLE);
    }

    public void reserveBook(String isbn) {
        try {
            library.changeBookState(isbn, State.RESERVED);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void loanBook(String isbn) {
        try {
            library.changeBookState(isbn, State.LOANED);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void returnBook(String isbn) {
        try {
            library.changeBookState(isbn, State.IDLE);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void save(Book book) {
        library.addBook(book);
        sender.send("Książka o tytule: " + book.getTitles() + " pojawiła się w bibliotece");
    }

    private Library lookupLibraryEjb() throws NamingException {
        final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(InitialContext.PROVIDER_URL, "remote://localhost:4447");
        final Context context = new InitialContext(jndiProperties);
        return (Library) context.lookup("java:global/library-ejb/LibraryImpl!pl.basistam.ejb.Library");
        }
}
