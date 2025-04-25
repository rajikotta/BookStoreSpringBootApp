package com.raji.bookstore.services;

import com.raji.bookstore.model.domain.AuthorDto;
import com.raji.bookstore.model.entities.AuthorEntity;
import org.springframework.stereotype.Service;

public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity author);
}
