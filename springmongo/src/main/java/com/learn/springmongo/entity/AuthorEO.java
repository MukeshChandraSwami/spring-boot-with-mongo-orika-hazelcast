package com.learn.springmongo.entity;

import com.mongodb.BasicDBObject;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AuthorEO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String authorId = UUID.randomUUID().toString() + (new Date().getTime() * (long)Math.random());
    private Long createdAt = new Date().getTime();
    private Long updatedAt = new Date().getTime();
    private String createdBy;
    private String updatedBy;
    private String name;
    private String contactNum;
    private List<String> books;

    public String getAuthorId() {
        return authorId;
    }

    public AuthorEO setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public AuthorEO setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public AuthorEO setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public AuthorEO setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public AuthorEO setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorEO setName(String name) {
        this.name = name;
        return this;
    }

    public String getContactNum() {
        return contactNum;
    }

    public AuthorEO setContactNum(String contactNum) {
        this.contactNum = contactNum;
        return this;
    }

    public List<String> getBooks() {
        return books;
    }

    public AuthorEO setBooks(List<String> books) {
        this.books = books;
        return this;
    }
}
