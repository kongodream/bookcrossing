package com.bookcrossing.dataLayer.entity;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@javax.persistence.Entity
@Table(name = "transfers")
public class Transfer extends Entity {
    @Column
    private LocalDateTime datePull;

    @Column
    private LocalDateTime datePush;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    public Transfer() {
    }

    public Transfer(Book book, User user) {
        this.book = book;
        this.user = user;
        this.datePull = LocalDateTime.now();

    }

    public LocalDateTime getDatePull() {
        return datePull;
    }

    public void setDatePull(LocalDateTime datePull) {
        this.datePull = datePull;
    }

    public LocalDateTime getDatePush() {
        return datePush;
    }

    public void setDatePush(LocalDateTime datePush) {
        this.datePush = datePush;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
