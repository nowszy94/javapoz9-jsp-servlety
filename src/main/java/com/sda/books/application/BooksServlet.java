package com.sda.books.application;

import com.sda.books.domain.BooksService;
import com.sda.books.domain.model.Book;
import com.sda.books.domain.port.BooksRepository;
import com.sda.books.infrastructure.memory.InMemoryBooksRepository;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class BooksServlet extends HttpServlet {

    private BooksService booksService;
    private BooksViews booksViews;

    @Override
    public void init() throws ServletException {
        List<Book> books = Arrays.asList(new Book("12345", "Quo Vadis", "Lorem ipsum", "Henryk Sienkiewicz", LocalDate.of(1895, 5, 20)),
                new Book("abc321", "W Pustyni i w Puszczy", "Lorem ipsum", "Henryk Sienkiewicz", LocalDate.of(1911, 2, 10)),
                new Book("987654", "Dziady IV", "Lorem ipsum", "Adam Mickiewicz", LocalDate.of(1815, 8, 1)));
        BooksRepository booksRepository = new InMemoryBooksRepository(books);

        booksService = new BooksService(booksRepository);
        booksViews = new BooksViews();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String author = req.getParameter("author");
        List<Book> books = StringUtils.isEmpty(author) ?
                booksService.findAll() :
                booksService.findByAuthor(author);
        booksViews.printBooks(resp.getWriter(), books);
        resp.setContentType("text/html");
//        resp.addHeader("Content-Type", "text/html");
    }
}
