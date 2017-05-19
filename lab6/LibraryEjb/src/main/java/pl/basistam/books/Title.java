package pl.basistam.books;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.io.Serializable;

@XmlRootElement
public class Title implements Serializable {
    private String language;
    private String name;

    @XmlAttribute(name = "lang")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    @XmlValue
    public void setName(String title) {
        this.name = title;
    }

    @Override
    public String toString() {
        return "Tytuł w języku " + language + ": " + name;
    }

}
