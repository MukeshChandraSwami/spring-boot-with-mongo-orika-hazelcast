package com.learn.springdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "AUTHORS")
public class AuthorEO {

    @Id
    private String authorId = UUID.randomUUID().toString() + (new Date().getTime() * (long)Math.random());
    @Column(name = "CLM_CREATED_AT")
    private Long createdAt = new Date().getTime();
    @Column(name = "CLM_UPDATED_AT")
    private Long updatedAt = new Date().getTime();
    @Column(name = "CLM_CREATED_BY")
    private String createdBy;
    @Column(name = "CLM_UPDATED_BY")
    private String updatedBy;
    @NotNull
    @Column(name = "CLM_NAME")
    private String name;
    @NotNull
    @Column(name = "CLM_CONTACT_NUMBER")
    private String contactNum;
    @OneToMany(mappedBy = "bookId",targetEntity = BookEO.class, fetch = FetchType.EAGER)
    private List<String> books;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public String getAuthorId() { return this.authorId; }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
