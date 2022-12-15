package com.graphql.learn.service;

import com.graphql.learn.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    Book update (Book book, Long id);

    String delete(Long id);

    List<Book> getAll();

    Book getBookById(Long id);
}
