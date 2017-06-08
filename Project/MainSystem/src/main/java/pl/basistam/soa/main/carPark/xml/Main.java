package pl.basistam.soa.main.carPark.xml;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws JAXBException {
        final File outputFile = new File("/home/marcin/Documents/soa/Project/parking.xml");
        JAXBContext context = JAXBContext.newInstance(Areas.class);
        Areas areas = new Areas();
        Area area = new Area();
        area.setId(1);
        area.setSpots(new ArrayList<Integer>() {
            {
                add(2);
                add(22);
                add(23);
            }
        });
        areas.getAreas().add(area);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(areas, outputFile);
    }
}
