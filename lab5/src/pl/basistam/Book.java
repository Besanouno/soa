package pl.basistam;

import java.util.List;
public class Book {
    private List<String> authors;
    private List<Title> titles;
    private String isbn;

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authorList) {
        this.authors = authorList;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titleList) {
        this.titles = titleList;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (titles != null) {
            titles.forEach((t) -> {
                builder.append(t);
                builder.append("\n");
            });
        }
        if (authors != null) {
            builder.append("Autorzy: ");
            authors.forEach((a) -> {
                builder.append(a);
                builder.append(",");
            });
        }
        builder.append("\n");
        builder.append("ISBN: ").append(isbn);
        builder.append("\n");
        return builder.toString();
    }
}
