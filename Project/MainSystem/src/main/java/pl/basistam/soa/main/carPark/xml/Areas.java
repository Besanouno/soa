package pl.basistam.soa.main.carPark.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "areas")
public class Areas {
    private List<Area> areas = new ArrayList<>();

    @XmlElement(name = "area")
    public List<Area> getAreas() {
        return areas;
    }
}
