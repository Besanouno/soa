package pl.basistam.zad3.books;

import pl.basistam.AbstractBooksInput;
import pl.basistam.Book;
import pl.basistam.XmlBuilder;

public class BooksInput extends AbstractBooksInput {

    public BooksInput(XmlBuilder builder) {
        super(builder);
    }

    protected void addNew(Book book) {
        if (book != null) {
            xml.save(book);
        }
    }
}
