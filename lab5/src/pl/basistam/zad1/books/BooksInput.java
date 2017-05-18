package pl.basistam.zad1.books;

import pl.basistam.AbstractBooksInput;
import pl.basistam.Book;
import pl.basistam.XmlBuilder;


public class BooksInput extends AbstractBooksInput {

    public BooksInput(XmlBuilder xml) {
        super(xml);
    }

    @Override
    protected void addNew(Book book) {
        if (book != null) {
            try {
                xml.save(book);
            } catch (Exception e) {
                System.out.println("Błędne dane!");
                e.printStackTrace();
            }
        }
    }
}
