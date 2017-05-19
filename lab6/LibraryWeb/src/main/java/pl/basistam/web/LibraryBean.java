package pl.basistam.web;

import pl.basistam.books.Book;
import pl.basistam.books.State;
import pl.basistam.ejb.Library;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.List;

@ManagedBean(name = "libraryBean")
@ApplicationScoped
public class LibraryBean {
    private Library library;

    public LibraryBean() throws NamingException {
        this.library = lookupLibraryEjb();
        Book book = new Book();
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

    public void reserveBook(String id) {
        try {
            library.changeBookState(Long.parseLong(id), State.RESERVED);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void loanBook(String id) {
        try {
            library.changeBookState(Long.parseLong(id), State.LOANED);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void returnBook(String id) {
        try {
            library.changeBookState(Long.parseLong(id), State.IDLE);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private Library lookupLibraryEjb() throws NamingException {
        final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(InitialContext.PROVIDER_URL, "remote://localhost:4447");
        final Context context = new InitialContext(jndiProperties);
        return (Library) context.lookup("java:app/library/LibraryImpl!pl.basistam.ejb.Library");
    }
}
