package com.sda.books.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Book {
    private String isbn;
    private String title;
    private String description;
    private String author;
    private LocalDate date;
}
