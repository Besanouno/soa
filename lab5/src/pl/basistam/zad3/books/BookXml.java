package pl.basistam.zad3.books;

import pl.basistam.Book;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "book")
@XmlType(propOrder={"authors", "titles", "isbn"})
public class BookXml {
    private List<String> authors;
    private List<TitleXml> titles;
    private String isbn;


    public static BookXml fromBook(Book book) {
        BookXml bookXml = new BookXml();
        bookXml.setAuthors(book.getAuthors());
        bookXml.setTitles(book.getTitles().stream().map(TitleXml::fromTitle).collect(Collectors.toList()));
        bookXml.setIsbn(book.getIsbn());
        return bookXml;
    }

    @XmlElement(name = "author")
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authorList) {
        this.authors = authorList;
    }

    @XmlElement(name = "title")
    public List<TitleXml> getTitles() {
        return titles;
    }

    public void setTitles(List<TitleXml> titleList) {
        this.titles = titleList;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (titles != null) {
            titles.forEach((t) -> {
                builder.append(t);
                builder.append("\n");
            });
        }
        if (authors != null) {
            builder.append("Autorzy: ");
            authors.forEach((a) -> {
                builder.append(a);
                builder.append(",");
            });
        }
        builder.append("\n");
        builder.append("ISBN: ").append(isbn);
        builder.append("\n");
        return builder.toString();
    }
}
