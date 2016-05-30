package com.bookcrossing.dataLayer.entity.dto;

import com.bookcrossing.dataLayer.entity.Book;
import com.bookcrossing.dataLayer.entity.Genre;

public class BookDTO {
    private int id;
    private String title;
    private String author;
    private Genre genre;
    private UserDTO creator;
    private UserDTO owner;
    private String picture;
    private String description;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.genre = book.getGenre();
        this.creator = new UserDTO(book.getCreator());
        this.picture = book.getPicture();
        this.description = book.getDescription();
        if(book.getOwner()!=null){
            this.owner = new UserDTO(book.getOwner());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
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

    public UserDTO getOwner() {
        return owner;
    }

    public void setOwner(UserDTO owner) {
        this.owner = owner;
    }
}