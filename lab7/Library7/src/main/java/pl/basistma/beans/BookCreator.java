package pl.basistma.beans;

import lombok.Data;
import pl.basistam.books.Book;
import pl.basistam.books.State;
import pl.basistam.books.Title;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookCreator {
    public BookCreator( String author, String title, String language, String isbn) {
        this.author = author;
        this.title = title;
        this.language = language;
        this.isbn = isbn;
    }

    private String author;
    private String title;
    private String language;
    private String isbn;

    public Book createBook() {
        Book book = new Book();
        book.setState(State.IDLE);
        book.setIsbn(isbn);
        book.setTitles(createTitles());
        book.setAuthors(createAuthors());
        return book;
    }

    private List<String> createAuthors() {
        List<String> authors = new ArrayList<>();
        authors.add(author);
        return authors;
    }

    private List<Title> createTitles() {
        List<Title> titles = new ArrayList<>();
        Title title = new Title();
        title.setName(this.title);
        title.setLanguage(language);
        titles.add(title);
        return titles;
    }
}
