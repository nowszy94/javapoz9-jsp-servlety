package com.sda.books.infrastructure.memory;

import com.sda.books.domain.model.Book;
import com.sda.books.domain.port.BooksRepository;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryBooksRepository implements BooksRepository {
    private List<Book> books;

    public InMemoryBooksRepository(List<Book> books) {
        this.books = books;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return books.stream()
                .filter(e -> StringUtils.containsIgnoreCase(e.getAuthor(), author))
                .collect(Collectors.toList());
    }
}
