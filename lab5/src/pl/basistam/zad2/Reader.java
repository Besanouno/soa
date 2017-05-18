package pl.basistam.zad2;

import org.xml.sax.SAXException;
import pl.basistam.zad3.books.Books;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class Reader {
    public void read() throws JAXBException, SAXException {
        final File inputFile = new File("books.xml");
        if (!inputFile.exists()) {
            System.err.println("Plik nie istneieje");
            return;
        }
        JAXBContext context = JAXBContext.newInstance(Books.class);
        Unmarshaller um = context.createUnmarshaller();
        um.setSchema(SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI)
                .newSchema(new File("books.xsd")));
        Books books = (Books) um.unmarshal(inputFile);
        books.print();
    }
}
