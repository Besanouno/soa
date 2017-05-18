package pl.basistam;

public class Title {
    private String language;
    private String title;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Tytuł w języku " + language + ": " + title;
    }
}
