package com.learn.springdemo.entity.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(value = "AUTHORS")
public class MongoAuthorEO {

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

    public MongoAuthorEO setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public MongoAuthorEO setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public MongoAuthorEO setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public MongoAuthorEO setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public MongoAuthorEO setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public String getName() {
        return name;
    }

    public MongoAuthorEO setName(String name) {
        this.name = name;
        return this;
    }

    public String getContactNum() {
        return contactNum;
    }

    public MongoAuthorEO setContactNum(String contactNum) {
        this.contactNum = contactNum;
        return this;
    }

    public List<String> getBooks() {
        return books;
    }

    public MongoAuthorEO setBooks(List<String> books) {
        this.books = books;
        return this;
    }
}
