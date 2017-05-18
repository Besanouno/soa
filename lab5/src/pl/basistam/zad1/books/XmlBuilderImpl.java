package pl.basistam.zad1.books;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import pl.basistam.Book;
import pl.basistam.Title;
import pl.basistam.XmlBuilder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XmlBuilderImpl implements XmlBuilder {
    public void save(Book book) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;
            File file = new File("books.xml");
            Element root;
            if (file.exists()) {
                document = builder.parse(file);
                root = document.getDocumentElement();
            } else {
                document = builder.newDocument();
                root = document.createElement("books");
            }
            Element element = document.createElement("book");
            for (String a : book.getAuthors()) {
                Element author = document.createElement("author");
                author.setTextContent(a);
                element.appendChild(author);
            }
            for (Title t : book.getTitles()) {
                Element title = document.createElement("title");
                title.setTextContent(t.getTitle());
                title.setAttribute("lang", t.getLanguage());
                element.appendChild(title);
            }
            Element isbn = document.createElement("isbn");
            isbn.setTextContent(book.getIsbn());
            element.appendChild(isbn);

            root.appendChild(element);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            Source source = new DOMSource(document);
            Result result = new StreamResult(file);
            transformer.transform(source, result);
        } catch(Exception e) {
            System.err.println("Błąd w zapisie");
        }
    }
}
