package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

public class MemBookDao implements BookDao {

    private List<Book> books;

    public MemBookDao() {
        ArrayList<Book> lBooks = new ArrayList<Book>();
        lBooks.add(new Book("978-1400079988", "War and Peace",
                "A soaring classic about politics.",
                1296, List.of("Leo Tolstoy")));
        lBooks.add(new Book("978-0451524935", "1984",
                "A chilling dystopian fable.",
                328, List.of("George Orwell")));
        lBooks.add(new Book("978-0786819881", "Don't Let the Pigeon Drive the Bus",
                "A children's book about a stubborn pigeon.",
                40, List.of("Mo Willems")));
        lBooks.add(new Book("978-1472439055", "The Field Guide to Understanding 'Human Error'",
                "An exploration into the causes and attributions of errors.",
                248, List.of("Sidney Dekker")));
        lBooks.add(new Book("978-1617297571", "Spring in Action, Sixth Edition",
                "A practical deep-dive into the Java Spring Framework.",
                520, List.of("Craig Walls")));

        this.books = lBooks;
    }

    @Override
    public Book find(String key) {
        for (Book book : books) {
            if (book.getIsbn().equals(key)) {
                return book;
            }
        }
        return new Book();
    }

    @Override
    public List<Book> list() {
        return this.books;
    }
}
