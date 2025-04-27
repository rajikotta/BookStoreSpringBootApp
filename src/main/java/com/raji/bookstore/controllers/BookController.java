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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping(path = "/books")
    public List<BookDto> listBooks() {

        List<BookEntity> authors = bookService.findAll();
        return authors.stream()
                .map(bookMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/authors/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable("isbn") String isbn) {
        Optional<BookEntity> foundAuthor = bookService.findOne(isbn);
        return foundAuthor.map(authorEntity -> {
            AuthorDto authorDto = authorMapper.mapTo(authorEntity);
            return new ResponseEntity<>(authorDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
