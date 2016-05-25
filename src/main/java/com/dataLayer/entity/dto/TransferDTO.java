package com.dataLayer.entity.dto;

import com.dataLayer.entity.Transfer;

import java.time.LocalDateTime;

public class TransferDTO {
    private int id;
    private LocalDateTime datePull;
    private LocalDateTime datePush;
    private BookDTO book;
    private UserDTO user;

    public TransferDTO(Transfer transfer) {
        this.id = transfer.getId();
        this.datePull = transfer.getDatePull();
        this.datePush = transfer.getDatePush();
        this.book = new BookDTO(transfer.getBook());
        this.user = new UserDTO(transfer.getUser());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
