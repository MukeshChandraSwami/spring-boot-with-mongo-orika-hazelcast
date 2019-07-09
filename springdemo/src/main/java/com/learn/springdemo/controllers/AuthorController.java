package com.learn.springdemo.controllers;

import com.learn.springdemo.entity.AuthorEO;
import com.learn.springdemo.entity.BookEO;
import com.learn.springdemo.response.AuthorResponse;
import com.learn.springdemo.response.BookResponse;
import com.learn.springdemo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}/get")
    public AuthorResponse getAuthorById(@PathVariable(value = "id") String id){
        return authorService.getAuthorById(id);
    }

    @PostMapping("/post")
    public AuthorResponse addAuthor(@RequestBody AuthorEO author){
        return authorService.addAuthor(author);
    }
}
