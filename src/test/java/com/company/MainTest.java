package com.company;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.List;

class MainTest {

    Library library = new Library();


    LibraryMain main = new LibraryMain();

    @Spy
    List<Book> books = library.getBooks();


    @Test
    void showBookList() {


        main.showBookList();


    }

    @Test
    void filterByName() {
        Assertions.assertEquals(0, main.filterByName("fail").size());
        Assertions.assertEquals(1, main.filterByName("Book2").size());
    }

    @Test
    void filterByGenre() {
        Assertions.assertEquals(0, main.filterByGenre("fail").size());
        Assertions.assertEquals(1, main.filterByGenre("science").size());
    }

    @Test
    void filterByAuthor() {
        Assertions.assertEquals(0, main.filterByAuthor("fail").size());
        Assertions.assertEquals(1, main.filterByAuthor("Author2").size());
    }

    @Test
    void filterByPublicationDate() {
        Assertions.assertEquals(0, main.filterByPublicationDate("fail").size());
        Assertions.assertEquals(1, main.filterByPublicationDate("2002").size());
    }

    @Test
    void filterByRating() {
        main.filterByRating();
    }

    @Test
    @DisplayName(" test loan when the book is already loaned")
    void loanShouldThrowException() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            main.loan("Book2");
        });
        Assertions.assertEquals(" the book is already loaned", e.getMessage());
    }

}