package com.learn.springmongo.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class BookEO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public BookEO setBookId(String bookId) {
        this.bookId = bookId;
        return this;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public BookEO setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public BookEO setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public BookEO setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public BookEO setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookEO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookEO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthorId() {
        return authorId;
    }

    public BookEO setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }
}
