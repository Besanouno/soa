package pl.basistam.service;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.basistam.model.Book;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.math.BigDecimal;

@ManagedBean
@SessionScoped
@Data
public class BookSaver {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private BigDecimal price;
    private int year;

    @ManagedProperty("#{library}")
    @Getter(AccessLevel.NONE)
    private Library library;

    public String add() {
        id = null;
        title = "";
        author = "";
        isbn = "";
        price = BigDecimal.ZERO;
        year = 0;
        return "bookEdit.xhtml";
    }

    public String edit(Long id) {
        Book book = library.find(id);
        this.id = id;
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
        this.year = book.getYear();
        this.price = book.getPrice();
        return "bookEdit.xhtml";
    }

    public String delete(Long id) {
        library.delete(id);
        return "index.xhtml";
    }

    public String save() {
        library.save(convertToBook());
        return "index.xhtml";
    }

    private Book convertToBook() {
        return Book.builder()
                .id(this.id)
                .author(this.author)
                .title(this.title)
                .isbn(this.isbn)
                .year(this.year)
                .price(this.price)
                .build();
    }
}
