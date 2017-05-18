package pl.basistam.zad2;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;

/**
 * Created by marcin on 20.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        try {
            reader.read();
        } catch (UnmarshalException e) {
            System.err.println("Błędna struktura pliku!");
        } catch (JAXBException | SAXException e) {
            e.printStackTrace();
        }
    }
}
