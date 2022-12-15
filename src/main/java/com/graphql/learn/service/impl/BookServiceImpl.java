package com.graphql.learn.service.impl;

import com.graphql.learn.Book;
import com.graphql.learn.BookRepository;
import com.graphql.learn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book create(Book book) {
        Book save = new Book();
        save.setTitle(book.getTitle());
        save.setAuthor(book.getAuthor());
        save.setDescription(book.getDescription());
        save.setPages(book.getPages());
        save.setPrice(book.getPrice());
        return bookRepository.save(save);
    }

    @Override
    public Book update(Book book, Long id) {
        Book save = bookRepository.findById(id).get();
        save.setTitle(book.getTitle());
        save.setAuthor(book.getAuthor());
        save.setDescription(book.getDescription());
        save.setPages(book.getPages());
        save.setPrice(book.getPrice());
        return bookRepository.save(save);
    }

    @Override
    public String delete(Long id) {
        Book save = bookRepository.findById(id).get();
        bookRepository.delete(save);
        return "Deleted Successfully with id: " + id;
    }

    @Override
    public List<Book> getAll() {
        List<Book> book = bookRepository.findAll();
        return book;
    }

    @Override
    public Book getBookById(Long id) {
        Book save = bookRepository.findById(id).get();
        return save;
    }
}
