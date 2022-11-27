package com.company;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.lang.Exception;


public class LibraryMain {

    static Library library = new Library();
    static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("\n Enter 0 to view the list of the book. " +
                "\n Enter 1 to search your book by name" +
                "\n Enter 2 to search your book by genre. " +
                "\n Enter 3 to search your book by author. " +
                "\n Enter 4 to search your book by publication Date. " +
                "\n Enter 5 to search the highest ratings book "+
                "\n Enter 6 to select your book"
        );
        int answer = in.nextInt();
        switch (answer) {
            case 0:
                showBookList();
                System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                main(args);

                int again = in.nextInt();
                break;

            case 1:
                System.out.println("\n Enter the name of the book");
                String name = in.next();
                filterByName(name).stream().forEach(System.out::println);
                System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                main(args);

                int again2 = in.nextInt();
                break;
            case 2:
                System.out.println("\n Enter the genre of the book");
                String genre = in.next();
                filterByGenre(genre).stream().forEach(System.out::println);
                System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                main(args);

                int again3 = in.nextInt();
                break;
            case 3:
                System.out.println("\n Enter the author of the book");
                String author = in.next();
                filterByAuthor(author).stream().forEach(System.out::println);
                System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                main(args);

                int again4 = in.nextInt();
                break;
            case 4:
                System.out.println("\n Enter the publication Date of the book");
                String date = in.next();
                filterByPublicationDate(date).stream().forEach(System.out::println);
                System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                main(args);

                int again5 = in.nextInt();
                break;

            case 5:
                filterByRating();
                System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                main(args);

                int again6 = in.nextInt();
                break;

            case 6:
                System.out.println("\n Enter the name of the book to loan");
                String book = in.next();
                try {
                    loan(book);
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
                break;
        }


    }

    public static void showBookList() {
        library.getBooks().stream().forEach(System.out::println);
    }

    public static List<Book> filterByName(String name) {
        List<Book> books = library.getBooks().stream().filter(b -> b.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        return books;
    }

    public static List<Book>  filterByGenre(String genre) {
        List<Book> books = library.getBooks().stream().filter(b -> b.getGenre().equals(genre)).collect(Collectors.toList());
        return books;
    }
    public static List<Book>  filterByAuthor(String author) {
        List<Book> books = library.getBooks().stream().filter(b -> b.getAuthor().equals(author)).collect(Collectors.toList());
        return books;
    }  public static List<Book> filterByPublicationDate(String date) {
        List<Book> books = library.getBooks().stream().filter(b -> b.getPublicationDate().equals(date)).collect(Collectors.toList());
        return books;
    }

    public static void filterByRating() {
        List<Book> books = library.getBooks().stream().sorted(Comparator.comparingDouble(Book::getRating)
                .reversed()).collect(Collectors.toList());
        books.stream().forEach(System.out::println);

    }

    public static void loan(String book) throws Exception{
        List<Book> books = library.getBooks();

        for( Book b : books){
            if(b.getName().equalsIgnoreCase(book)){
                if(b.isLoaned()){
                    throw new Exception(" the book is already loaned");
                }
                else{
                    System.out.println("the payment for this book is " + b.getPrice());
                    System.out.println("Do you want to loan this book? (y/n)");
                    String answer = in.next();
                    if(answer.equalsIgnoreCase("y")){
                        b.setLoaned(true);
                        System.out.println("the book is loaned");
                    }
                    else{
                        System.out.println("the book is not loaned");
                    }
                }

            }


        }


    }
}
