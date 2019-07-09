package com.learn.springmongo.model;

import java.io.Serializable;
import java.util.List;

public class AuthorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String authorId;
    private Long createdAt;
    private Long updatedAt;
    private String createdBy;
    private String updatedBy;
    private String name;
    private String contactNum;
    private List<String> books;

    public String getAuthorId() {
        return authorId;
    }

    public AuthorModel setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public AuthorModel setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public AuthorModel setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public AuthorModel setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public AuthorModel setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getContactNum() {
        return contactNum;
    }

    public AuthorModel setContactNum(String contactNum) {
        this.contactNum = contactNum;
        return this;
    }

    public List<String> getBooks() {
        return books;
    }

    public AuthorModel setBooks(List<String> books) {
        this.books = books;
        return this;
    }
}
