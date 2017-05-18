package pl.basistam.zad3.books;

public class Main {
    public static void main(String[] args) {
        BooksInput input = new BooksInput(new XmlBuilderImpl());
        input.add();
    }
}
