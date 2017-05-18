package pl.basistam.zad3.books;

import pl.basistam.Book;
import pl.basistam.XmlBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class XmlBuilderImpl implements XmlBuilder {
    public void save(Book newBook) {
        try {
            BookXml bookXml = BookXml.fromBook(newBook);
            System.out.println("Zapisuje");
            JAXBContext context = JAXBContext.newInstance(Books.class);
            final File outputFile = new File("books.xml");
            Unmarshaller um = context.createUnmarshaller();

            if (!outputFile.exists()) {
                try {
                    outputFile.createNewFile();
                    initFile(outputFile);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
            Books books = (Books) um.unmarshal(outputFile);

            List<BookXml> bookList = books.getBooks();
            if (bookList == null) bookList = new ArrayList<>();
            bookList.add(bookXml);
            books.setBooks(bookList);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(books, outputFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void initFile(File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.write("<books>\n");
        writer.write("</books>");
        writer.close();
    }
}
