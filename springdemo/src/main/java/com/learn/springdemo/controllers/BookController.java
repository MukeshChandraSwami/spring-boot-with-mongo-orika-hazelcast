package com.learn.springdemo.controllers;

import com.learn.springdemo.entity.BookEO;
import com.learn.springdemo.request.BookRequest;
import com.learn.springdemo.response.BookResponse;
import com.learn.springdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}/get")
    public BookResponse getBookById(@PathVariable(value = "id") String id){
        return bookService.getBookById(id);
    }

    @PostMapping("/post")
    public BookResponse postBook(@RequestBody BookEO book){
        return bookService.postBook(book);
    }
}
