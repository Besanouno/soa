package pl.basistam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract public class AbstractBooksInput {
    private boolean end = false;
    private Scanner scanner = new Scanner(System.in);

    protected XmlBuilder xml;

    public AbstractBooksInput(XmlBuilder xml) {
        this.xml = xml;
    }

    public void add() {
        while (!end) {
            System.out.println("Czy wprowadzić nową książkę?");
            String input = scanner.nextLine();
            if (input.equals("nie")) {
                end = true;
            } else {
                addNew(getBook());
            }
        }
    }

    abstract protected void addNew(Book book);

    public Book getBook() {
        System.out.println("Podaj autora");
        String input;
        List<String> authors = getAuthors();
        List<Title> titles = getTitles();
        String isbn = getIsbn();
        return saveBook(authors, titles, isbn);
    }

    private Book saveBook(List<String> authors, List<Title> titles, String isbn) {
        System.out.println("Czy dane są poprawne? (nie / tak)");
        String correct = scanner.nextLine();
        Book result = null;
        while (!correct.equals("nie") && !correct.equals("tak")) {
            System.out.println("Czy dane są poprawne? (nie / tak)");
            correct = scanner.nextLine();
        }
        if (correct.equals("nie")) {
            result = null;
        } else if (correct.equals("tak")) {
            Book book = new Book();
            book.setAuthors(authors);
            book.setTitles(titles);
            book.setIsbn(isbn);
            result = book;
        }
        return result;
    }

    private String getIsbn() {
        System.out.println("Podaj numer ISBN");
        return scanner.nextLine();
    }

    private List<Title> getTitles() {
        while (true) {
            List<Title> titles = new ArrayList<>();
            String title;
            String lang;
            System.out.println("Podaj jezyk tytułu");
            lang = scanner.nextLine();
            System.out.println("Podaj tytuł");
            title = scanner.nextLine();
            while (!lang.isEmpty() && !title.isEmpty()) {
                Title t = new Title();
                t.setLanguage(lang);
                t.setTitle(title);
                titles.add(t);
                System.out.println("Podaj kolejny język tytułu lub wciśnij enter aby przejść dalej");
                lang = scanner.nextLine();
                if (lang.isEmpty()) {
                    break;
                }
                System.out.println("Podaj tytuł w tym jezyku lub wciśnij enter aby anulować");
                title = scanner.nextLine();
            }
            if (titles.size() == 0) {
                System.out.println("Podaj przynajmniej jeden tytuł!");
            } else {
                return titles;
            }
        }
    }

    private List<String> getAuthors() {
        while (true) {
            String input;
            List<String> authors = new ArrayList<>();
            while (!(input = scanner.nextLine()).isEmpty()) {
                authors.add(input);
                System.out.println("Podaj kolejnego autora, lub wciśnij enter aby przejść dalej");
            }
            if (authors.size() == 0) {
                System.out.println("Podaj przynajmniej jednego autora!");
            } else {
                return authors;
            }
        }
    }
}
