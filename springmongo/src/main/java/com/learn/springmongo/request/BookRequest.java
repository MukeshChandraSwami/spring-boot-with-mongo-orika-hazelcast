package com.learn.springmongo.request;

public class BookRequest {

    private String createdBy;
    private String updatedBy;
    private String title;
    private String description;
    private String authorId;

    public String getCreatedBy() {
        return createdBy;
    }

    public BookRequest setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public BookRequest setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthorId() {
        return authorId;
    }

    public BookRequest setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }
}
