package pl.basistam.zad3.books;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "books")
public class Books {
    private List<BookXml> books;

    @XmlElement(name = "book")
    public List<BookXml> getBooks() {
        return books;
    }

    public void setBooks(List<BookXml> books) {
        this.books = books;
    }

    public void print() {
        if (books != null) {
            books.forEach(System.out::println);
        }
        System.out.println();
    }
}
