package com.devproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TempDB {
    public static List<Author> getAuthorsFromTempDB() {
        Author author1 = Author.newBuilder()
                .setAuthorId(1)
                .setBookId(1)
                .setFirstName("Charles")
                .setLastName("Dickens")
                .setGender("Male")
                .build();
        Author author2 = Author.newBuilder()
                .setAuthorId(2)
                .setBookId(1)
                .setFirstName("William")
                .setLastName("Shakespeare")
                .setGender("Male")
                .build();
        Author author3 = Author.newBuilder()
                .setAuthorId(3)
                .setBookId(1)
                .setFirstName("JK")
                .setLastName("Rowling")
                .setGender("Female")
                .build();
        Author author4 = Author.newBuilder()
                .setAuthorId(4)
                .setFirstName("Virginia")
                .setLastName("Woolf")
                .setGender("Female")
                .build();
        return Arrays.asList(author1, author2, author3, author4);
    }

    public static List<Book> getBooksFromTempDB() {
        Book b1 = Book.newBuilder().setBookId(1).setAuthorId(1).setTitle("Oliver Twist")
                .setPrice(123.3f).setPages(100).build();
        Book b2 = Book.newBuilder().setBookId(2).setAuthorId(1).setTitle("A Christmas Carol")
                .setPrice(223.3f).setPages(130).build();
        Book b3 = Book.newBuilder().setBookId(3).setAuthorId(2).setTitle("Hamlet")
                .setPrice(723.3f).setPages(90).build();
        Book b4 = Book.newBuilder().setBookId(4).setAuthorId(3).setTitle("Harry Potter")
                .setPrice(423.3f).setPages(300).build();
        Book b5 = Book.newBuilder().setBookId(5).setAuthorId(3).setTitle("The Casual Vacancy")
                .setPrice(523.3f).setPages(150).build();
        Book b6 = Book.newBuilder().setBookId(6).setAuthorId(4).setTitle("The Indian Heroes")
                .setPrice(323.3f).setPages(30).build();
        return Arrays.asList(b1, b2, b3, b4, b5, b6);
    }
}
