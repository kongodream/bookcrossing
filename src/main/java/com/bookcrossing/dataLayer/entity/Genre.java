package com.bookcrossing.dataLayer.entity;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Table(name = "genres")
public class Genre extends Entity {
    @Column
    private String title;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<Book> books;

    public Genre() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
