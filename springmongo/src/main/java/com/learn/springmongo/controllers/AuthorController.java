package com.learn.springmongo.controllers;

import com.learn.springmongo.entity.AuthorEO;
import com.learn.springmongo.response.AuthorResponse;
import com.learn.springmongo.response.CountResponse;
import com.learn.springmongo.response.PurgeResponse;
import com.learn.springmongo.response.Response;
import com.learn.springmongo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}/get")
    public Response getAuthorById(@PathVariable(value = "id") String id){
        return authorService.getAuthorById(id);
    }

    @PostMapping("/post")
    public Response addAuthor(@RequestBody AuthorEO author){
        return authorService.addAuthor(author);
    }

    @GetMapping("/count")
    public Response getTotalAuthors(){
        return authorService.getTotalAuthors();
    }

    @PutMapping("/{id}/update")
    public Response updateAuthor(@RequestBody AuthorEO author,
                                       @PathVariable(value = "id") String id){
        return authorService.updateAuthor(author,id);
    }

    @DeleteMapping("/{id}/purge")
    public Response purgeAuthor(@PathVariable(value = "id") String id){
        return authorService.purgeAuthor(id);
    }
}
