package com.learn.springmongo.repo;

import com.learn.springmongo.entity.BookEO;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BookRepo {

    public Optional<BookEO> findById(String bookId){

        return Optional.empty();
    }

    public Object save(BookEO book) {

        return book;
    }
}
