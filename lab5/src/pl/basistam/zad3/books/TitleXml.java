package pl.basistam.zad3.books;


import pl.basistam.Title;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class TitleXml {
    private String language;
    private String title;

    public static TitleXml fromTitle(Title title) {
        TitleXml titleXml = new TitleXml();
        titleXml.setLanguage(title.getLanguage());
        titleXml.setTitle(title.getTitle());
        return titleXml;
    }

    @XmlAttribute(name = "lang")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    @XmlValue
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Tytuł w języku " + language + ": " + title;
    }

}
