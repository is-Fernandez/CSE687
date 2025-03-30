package edu.syr.hw1;

import java.util.Objects;

public class Library {
    public String[] book;
    public void init(String[] book) {
        Library library = this;
        library.book = book;
    }
    public String search(String name) {
        for (String s : book) {
            if (Objects.equals(s, name)) {
                return s;
            }
        }
        return null;
    }
}
