package pl.basistam.soa.main.carPark.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "area")
public class Area {
    private Integer id;
    private List<Integer> spots;

    @XmlAttribute(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlAttribute(name = "id")
    public List<Integer> getSpots() {
        return spots;
    }

    public void setSpots(List<Integer> spots) {
        this.spots = spots;
    }
}
