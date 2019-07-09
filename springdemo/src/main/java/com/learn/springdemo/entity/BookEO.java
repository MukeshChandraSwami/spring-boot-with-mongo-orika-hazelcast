package com.learn.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity(name = "BOOKS")
public class BookEO{

    @Id
    private String bookId = UUID.randomUUID().toString() + (new Date().getTime() * (long)Math.random());
    @Column(name = "CLM_CREATED_AT")
    private Long createdAt = new Date().getTime();
    @Column(name = "CLM_UPDATED_AT")
    private Long updatedAt = new Date().getTime();
    @Column(name = "CLM_CREATED_BY")
    private String createdBy;
    @Column(name = "CLM_UPDATED_BY")
    private String updatedBy;
    @NotNull
    @Column(name = "CLM_TITLE")
    private String title;
    @Column(name = "CLM_DESCRIPTION")
    private String description;
    @NotNull
    @ManyToOne(targetEntity = AuthorEO.class)
    private String authorId;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getBookId() { return this.bookId; }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
