package com.raji.bookstore.controllers;

import com.raji.bookstore.mappers.AuthorMapper;
import com.raji.bookstore.mappers.Mapper;
import com.raji.bookstore.model.domain.AuthorDto;
import com.raji.bookstore.model.entities.AuthorEntity;
import com.raji.bookstore.services.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    AuthorService authorService;
    Mapper<AuthorEntity, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper) {

        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto) {
        AuthorEntity authorEntity = authorMapper.mapFrom(authorDto);
        AuthorEntity response = authorService.createAuthor(authorEntity);
        return authorMapper.mapTo(response);
    }
}
