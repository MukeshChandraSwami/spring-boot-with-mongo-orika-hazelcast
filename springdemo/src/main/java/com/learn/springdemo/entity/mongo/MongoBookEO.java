package com.learn.springdemo.entity.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(value = "BOOKS")
public class MongoBookEO {

    private String bookId = UUID.randomUUID().toString() + (new Date().getTime() * (long)Math.random());
    private Long createdAt = new Date().getTime();
    private Long updatedAt = new Date().getTime();
    private String createdBy;
    private String updatedBy;
    private String title;
    private String description;
    private String authorId;

    public String getBookId() {
        return bookId;
    }

    public MongoBookEO setBookId(String bookId) {
        this.bookId = bookId;
        return this;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public MongoBookEO setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public MongoBookEO setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public MongoBookEO setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public MongoBookEO setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MongoBookEO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MongoBookEO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthorId() {
        return authorId;
    }

    public MongoBookEO setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }
}
