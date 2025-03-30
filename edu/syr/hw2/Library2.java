package edu.syr.hw2;


import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Library2 {
    public List<Book> libraries = new ArrayList<>();
    public void addLib(Book book) {
        if (book != null) {
            libraries.add(book);
        }
    }

    public List<Book> search(Book searchBook) {
        List<Book> Return = new ArrayList<>();
        for (Book book : libraries) {

            if (book.getAuthor().toLowerCase().contains(searchBook.getAuthor().toLowerCase()) ||
                    book.getTitle().toLowerCase().contains(searchBook.getTitle().toLowerCase()) ||
                    book.getPublisher().toLowerCase().contains(searchBook.getPublisher().toLowerCase()) ||
                    book.getIsbn().contains(searchBook.getIsbn()) ||
                    book.getYearPublished() == searchBook.getYearPublished()) {
                Return.add(book);
            }
        }
        return Return;
    }
}

