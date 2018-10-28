package com.sda.books.domain;

import com.sda.books.domain.model.Book;
import com.sda.books.domain.port.BooksRepository;

import java.util.List;

public class BooksService {

    private BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public List<Book> findByAuthor(String author) {
        return booksRepository.findByAuthor(author);
    }
}
