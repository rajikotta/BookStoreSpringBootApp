package com.raji.bookstore.services;

import com.raji.bookstore.model.entities.BookEntity;

public interface BookService {
    BookEntity createBook(String isbn,BookEntity book);
}
