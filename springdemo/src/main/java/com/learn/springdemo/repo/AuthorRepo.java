package com.learn.springdemo.repo;

import com.learn.springdemo.entity.AuthorEO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends CrudRepository<AuthorEO,String> {
}
