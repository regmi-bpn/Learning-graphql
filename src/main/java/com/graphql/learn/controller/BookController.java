package com.graphql.learn.controller;

import com.graphql.learn.Book;
import com.graphql.learn.BookRepository;
import com.graphql.learn.service.BookService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }


    @MutationMapping("createBook")
    public Book create(@Argument BookInput book) {
        Book book1 = new Book();
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setDescription(book.getDescription());
        book1.setPages(book.getPages());
        book1.setPrice(book.getPrice());
        return bookService.create(book1);
    }

    @MutationMapping("updateBook")
    public Book update(@Argument UpdateBook book, @Argument("bookId") Long id) {
        Book book1 = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Not valid Id"));
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setDescription(book.getDescription());
        book1.setPages(book.getPages());
        book1.setPrice(book.getPrice());
        return bookService.update(book1, id);
    }

    @MutationMapping("deleteBook")
    public String delete(@Argument("bookId") Long id) {
        return bookService.delete(id);
    }

    @QueryMapping("allBooks")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @QueryMapping("getBook")
    public Book getBookById(@Argument("bookId") Long id) {
        return bookService.getBookById(id);
    }
}

@Getter
@Setter
class BookInput{

    private String title;

    private String description;

    private String author;

    private Double price;

    private Integer pages;
}

@Getter
@Setter
class UpdateBook{

    private String title;

    private String description;

    private String author;

    private Double price;

    private Integer pages;
}
