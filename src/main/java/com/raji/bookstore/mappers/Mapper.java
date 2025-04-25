package com.raji.bookstore.mappers;

import org.modelmapper.ModelMapper;

public interface Mapper<A, B> {
    B mapTo(A a);

    A mapFrom(B b);
}
