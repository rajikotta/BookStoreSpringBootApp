package com.raji.bookstore.controllers;

import com.raji.bookstore.mappers.Mapper;
import com.raji.bookstore.model.domain.AuthorDto;
import com.raji.bookstore.model.domain.BookDto;
import com.raji.bookstore.model.entities.AuthorEntity;
import com.raji.bookstore.model.entities.BookEntity;
import com.raji.bookstore.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    Mapper<BookEntity, BookDto> bookMapper;
    BookService bookService;

    public BookController(Mapper<BookEntity, BookDto> bookMapper, BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @PutMapping(path = "/books/{isbn}")
    public ResponseEntity<BookDto> createBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto) {
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity savedBook = bookService.createBook(isbn, bookEntity);

        BookDto savedBookDto = bookMapper.mapTo(savedBook);

        return new ResponseEntity<BookDto>(savedBookDto, HttpStatus.CREATED);

    }
}
