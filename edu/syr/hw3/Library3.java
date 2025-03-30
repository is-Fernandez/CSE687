package edu.syr.hw3;

import java.util.ArrayList;
import java.util.List;
import edu.syr.hw2.Book;

public class Library3 {
    private List<Book> catalog;
    public Library3() {
        catalog = new ArrayList<>();
    }
    public void add(Book b) {
        catalog.add(b);
    }
    public List<Book> search(Book lookFor) {
        List<Book> results = new ArrayList<>();
        for (Book curr : catalog) {
            // Check author (if specified in the search criteria)
            boolean authorMatch = (lookFor.getAuthor() != null && !lookFor.getAuthor().isEmpty() &&
                    lookFor.getAuthor().equalsIgnoreCase(curr.getAuthor())) ||
                    (lookFor.getTitle() != null && !lookFor.getTitle().isEmpty() &&
                            lookFor.getTitle().equalsIgnoreCase(curr.getAuthor())) ||
                    (lookFor.getPublisher() != null && !lookFor.getPublisher().isEmpty() &&
                            lookFor.getPublisher().equalsIgnoreCase(curr.getAuthor())) ||
                    (lookFor.getIsbn() != null && !lookFor.getIsbn().isEmpty() &&
                            lookFor.getIsbn().equalsIgnoreCase(curr.getAuthor()));

            boolean titleMatch = (lookFor.getTitle() != null && !lookFor.getTitle().isEmpty() &&
                    lookFor.getTitle().equalsIgnoreCase(curr.getTitle())) ||
                    (lookFor.getAuthor() != null && !lookFor.getAuthor().isEmpty() &&
                            lookFor.getAuthor().equalsIgnoreCase(curr.getTitle())) ||
                    (lookFor.getPublisher() != null && !lookFor.getPublisher().isEmpty() &&
                            lookFor.getPublisher().equalsIgnoreCase(curr.getTitle())) ||
                    (lookFor.getIsbn() != null && !lookFor.getIsbn().isEmpty() &&
                            lookFor.getIsbn().equalsIgnoreCase(curr.getTitle()));

            boolean publisherMatch = lookFor.getPublisher() != null && !lookFor.getPublisher().isEmpty() &&
                    lookFor.getPublisher().equalsIgnoreCase(curr.getPublisher());
            boolean isbnMatch = lookFor.getIsbn() != null && !lookFor.getIsbn().isEmpty() &&
                    lookFor.getIsbn().equals(curr.getIsbn());
            boolean yearMatch = lookFor.getYearPublished() != -1 &&
                    lookFor.getYearPublished() == curr.getYearPublished();
            boolean typeMatch = lookFor.getType() != Book.BookType.ANY &&
                    lookFor.getType() == curr.getType();

            // If any field matches, add the book to the results
            if (authorMatch || titleMatch || publisherMatch || isbnMatch || yearMatch || typeMatch) {
                results.add(curr);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Library3 lib = new Library3();
        lib.add(new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, Book.BookType.HARDCOVER));
        Book b2 = new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011, Book.BookType.PAPERBACK);
        Book b3 = new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016, Book.BookType.EBOOK);
        List<Book> results = lib.search(new Book(null, null, "Learning Spark",   null, -1, Book.BookType.ANY));
        for (Book b: results) {
            System.out.println(b.toString());
        }
    }
}


