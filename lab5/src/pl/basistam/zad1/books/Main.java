package pl.basistam.zad1.books;

import pl.basistam.AbstractBooksInput;

public class Main {
    public static void main(String[] args) {
        AbstractBooksInput input = new BooksInput(new XmlBuilderImpl());
        input.add();
    }
}
