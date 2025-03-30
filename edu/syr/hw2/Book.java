package edu.syr.hw2;


import java.util.Objects;

public class Book {
    private String author;
    private String title;
    private String publisher;
    private String isbn;
    private int yearPublished;
    private BookType type;

    public enum BookType {
        HARDCOVER, PAPERBACK, EBOOK, ANY
    }

    public Book(String a, String t, String p, String i, int y, BookType b) {
        if (a == null) {
            this.author = "";
        } else {
            this.author = a;
        }
        if (t == null) {
            this.title = "";
        } else {
            this.title = t;
        }
        if (p == null) {
            this.publisher = "";
        } else {
            this.publisher = p;
        }
        if (i == null) {
            this.isbn = "";
        } else {
            this.isbn = i;
        }
        this.yearPublished = y;
        if (b == null) {
            this.type = BookType.ANY;
        } else {
            this.type = b;
        }
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getIsbn() {
        return isbn;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public BookType getType() {return type;}

    public boolean matches(Book b) {
        // Check author (if specified in this book)
        if (author != null && b.author != null && !author.equalsIgnoreCase(b.author)) {
            return false;
        }
        // Check title (if specified in this book)
        if (title != null && b.title != null && !title.equalsIgnoreCase(b.title)) {
            return false;
        }
        // Check publisher (if specified in this book)
        if (publisher != null && b.publisher != null && !publisher.equalsIgnoreCase(b.publisher)) {
            return false;
        }
        // Check ISBN (if specified in this book)
        if (isbn != null && b.isbn != null && !isbn.equals(b.isbn)) {
            return false;
        }
        // Check yearPublished (if specified in this book)
        if (yearPublished != -1 && b.yearPublished != -1 && yearPublished != b.yearPublished) {
            return false;
        }
        // Check type (if specified in this book)
        if (type != BookType.ANY && b.type != BookType.ANY && type != b.type) {
            return false;
        }
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || !(o instanceof Book)) {
            return false;
        }
        Book that = (Book) o;

        // Compare author (if specified in both books)
        if (author != null && that.author != null && !author.equalsIgnoreCase(that.author)) {
            return false;
        }
        // Compare title (if specified in both books)
        if (title != null && that.title != null && !title.equalsIgnoreCase(that.title)) {
            return false;
        }
        // Compare publisher (if specified in both books)
        if (publisher != null && that.publisher != null && !publisher.equalsIgnoreCase(that.publisher)) {
            return false;
        }
        // Compare ISBN (if specified in both books)
        if (isbn != null && that.isbn != null && !isbn.equals(that.isbn)) {
            return false;
        }
        // Compare yearPublished (if specified in both books)
        if (yearPublished != -1 && that.yearPublished != -1 && yearPublished != that.yearPublished) {
            return false;
        }
        // Compare type (if specified in both books)
        if (type != BookType.ANY && that.type != BookType.ANY && type != that.type) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                //got lazy doing if else statements chose ?:
                author == null ? "" : author.toLowerCase(),
                title == null ? "" : title.toLowerCase(),
                publisher == null ? "" : publisher.toLowerCase(),
                isbn == null ? "" : isbn,
                yearPublished == -1 ? 0 : yearPublished,
                type == BookType.ANY ? "" : type
        );
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Book{");
        sb.append("author='").append(author == null ? "null" : author).append('\'')
                .append(", title='").append(title == null ? "null" : title).append('\'')
                .append(", publisher='").append(publisher == null ? "null" : publisher).append('\'')
                .append(", isbn='").append(isbn == null ? "null" : isbn).append('\'')
                .append(", yearPublished=").append(yearPublished == -1 ? "null" : yearPublished)
                .append(", type=").append(type == BookType.ANY ? "ANY" : type)
                .append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015, Book.BookType.HARDCOVER);
        Book b2 = new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011, Book.BookType.PAPERBACK);
        Book b3 = new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016, Book.BookType.EBOOK);
    }
}


