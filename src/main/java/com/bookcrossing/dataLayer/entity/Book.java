package com.bookcrossing.dataLayer.entity;

import com.bookcrossing.dataLayer.entity.dto.RequestBook;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@javax.persistence.Entity
@Table(name = "books")
public class Book extends Entity {
    @Column
    private String title;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors;
    @ManyToOne
    private Genre genre;
    @ManyToOne
    private User creator;
    @ManyToOne
    private User owner;
    @Column
    private String picture;
    @Column
    private String description;

    @OneToMany(mappedBy = "book",fetch = FetchType.EAGER)
    private List<Transfer> transfers;

    public Book() {
    }

    public Book(RequestBook book, User creator) {
        this.title = book.getTitle();
        this.authors = new HashSet<>(book.getAuthor());
        this.description = book.getDescription();
        this.genre = book.getGenre();
        this.picture = book.getPicture();
        this.creator = creator;
        this.owner = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
