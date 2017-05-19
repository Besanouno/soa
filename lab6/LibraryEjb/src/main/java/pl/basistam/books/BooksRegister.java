package pl.basistam.books;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BooksRegister {
    private String path = "/home/marcin/Documents/soa/lab6/books.xml";

    public List<Book> loadBooks() {
        List<Book> bookList;
        try {
            JAXBContext context = JAXBContext.newInstance(Books.class);
            final File outputFile = new File(path);
            Unmarshaller um = context.createUnmarshaller();
            Books books = (Books) um.unmarshal(outputFile);
            bookList = books.getBooks();
            if (bookList == null) bookList = new ArrayList<>();
        } catch (JAXBException e) {
            e.printStackTrace();
            bookList = new ArrayList<>();
        }
        return bookList;
    }

    public void saveBooks(List<Book> bookList) {
        try {
            JAXBContext context = JAXBContext.newInstance(Books.class);
            final File outputFile = new File(path);
            Unmarshaller um = context.createUnmarshaller();
            Books books = (Books) um.unmarshal(outputFile);
            books.setBooks(bookList);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(books, outputFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
