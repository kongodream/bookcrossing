package com.bookcrossing.dataLayer.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@javax.persistence.Entity
@Table(name = "exchanges")
public class Exchange extends Entity {
    @ManyToOne
    private User creator;
    @ManyToOne
    private User recipient;
    @ManyToOne
    private Book desiredBook;
    @OneToMany
    private List<Book> offeredBooks;
    @Column
    private boolean recipientConfirmation;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Exchange() {
    }

    public Exchange(User creator, User recipient, Book desiredBook, List<Book> offeredBooks) {
        this.creator = creator;
        this.recipient = recipient;
        this.desiredBook = desiredBook;
        this.offeredBooks = offeredBooks;
        this.createdAt = LocalDateTime.now();
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public Book getDesiredBook() {
        return desiredBook;
    }

    public void setDesiredBook(Book desiredBook) {
        this.desiredBook = desiredBook;
    }

    public List<Book> getOfferedBooks() {
        return offeredBooks;
    }

    public void setOfferedBooks(List<Book> offeredBooks) {
        this.offeredBooks = offeredBooks;
    }

    public boolean isRecipientConfirmation() {
        return recipientConfirmation;
    }

    public void setRecipientConfirmation(boolean recipientConfirmation) {
        this.recipientConfirmation = recipientConfirmation;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
