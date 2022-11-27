package com.company;

import java.util.ArrayList;
import java.util.List;

public class Library {


    List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Library() {
        books = new ArrayList<>();
        books.add(new Book("Book1", "children's book", "Author1", "1730", 5d, false, 10));
        books.add(new Book("Book2", "comedy", "Author2", "1990", 4.3d, true, 90));
        books.add(new Book("Book3", "science", "Author3", "1889", 4.1d, false , 15));
        books.add(new Book("Book4", "novel", "Author4", "2002", 3.7d, false, 24));
        books.add(new Book("Book5", "horror", "Author5", "1940", 3.3d, true,10));
        books.add(new Book("Book6", "drama", "Author6", "1995", 2.8d, false, 6));
        books.add(new Book("Book7", "action", "Author7", "1967", 2.5d, true, 12));

    }


}