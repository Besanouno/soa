package pl.basistam.soa.main.carPark.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class AreasReader {
    public Areas getAreas() {
        try {
            JAXBContext context = JAXBContext.newInstance(Areas.class);
            final File file = initFile();
            Unmarshaller um = context.createUnmarshaller();

            return  (Areas) um.unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException("Cannot read parking initialization data");
        }
    }

    private File initFile() {
        final File outputFile = new File("/home/marcin/Documents/soa/Project/parking.xml");
        if (!outputFile.exists()) {
            throw new RuntimeException("Cannot read parking initialization data");
        }
        return outputFile;
    }
}
