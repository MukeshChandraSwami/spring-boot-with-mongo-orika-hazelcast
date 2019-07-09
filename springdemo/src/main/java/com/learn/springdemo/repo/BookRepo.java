package com.learn.springdemo.repo;

import com.learn.springdemo.entity.BookEO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends CrudRepository<BookEO,String> {

}
