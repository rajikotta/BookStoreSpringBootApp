package com.raji.bookstore.repository;

import com.raji.bookstore.model.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {
}
