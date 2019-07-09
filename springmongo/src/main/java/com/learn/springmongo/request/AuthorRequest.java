package com.learn.springmongo.request;

import java.util.List;

public class AuthorRequest {

    private String createdBy;
    private String updatedBy;
    private String name;
    private String contactNum;
    private List<String> books;

    public String getCreatedBy() {
        return createdBy;
    }

    public AuthorRequest setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public AuthorRequest setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getContactNum() {
        return contactNum;
    }

    public AuthorRequest setContactNum(String contactNum) {
        this.contactNum = contactNum;
        return this;
    }

    public List<String> getBooks() {
        return books;
    }

    public AuthorRequest setBooks(List<String> books) {
        this.books = books;
        return this;
    }
}
