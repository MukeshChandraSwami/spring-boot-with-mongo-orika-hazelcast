package com.learn.springmongo.controllers;

import com.learn.springmongo.entity.BookEO;
import com.learn.springmongo.response.BookResponse;
import com.learn.springmongo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
