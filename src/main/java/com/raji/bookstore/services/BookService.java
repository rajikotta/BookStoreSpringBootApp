package com.raji.bookstore.services;

import com.raji.bookstore.model.domain.BookDto;
import com.raji.bookstore.model.entities.BookEntity;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    BookEntity createBook(String isbn, BookEntity book);

    List<BookEntity> findAll();


    Optional<BookEntity> findOne(String isbn);
}
