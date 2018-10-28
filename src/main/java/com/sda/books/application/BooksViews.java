package com.sda.books.application;

import com.sda.books.domain.model.Book;

import java.io.PrintWriter;
import java.util.List;

public class BooksViews {
    public void printBooks(PrintWriter printWriter, List<Book> books) {
        printWriter.println("<ul>");
        books.forEach(e -> printBookListItem(printWriter, e));
        printWriter.println("</ul>");
    }

    private void printBookListItem(PrintWriter printWriter, Book book) {
        printWriter.println("<li>");
        printWriter.println("<a href='#'>");
        printWriter.println(book.getTitle() + "(" + book.getAuthor() + ")");
        printWriter.println("</a>");
        printWriter.println("</li>");
    }
}
