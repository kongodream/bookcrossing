package com.bookcrossing.dataLayer.entity.dto;

import com.bookcrossing.dataLayer.entity.Genre;

public class RequestBook {
    private String title;
    private String author;
    private Genre genre;
    private String picture;
    private String description;

    public RequestBook() {
    }

    public RequestBook(String title, String author, Genre genre, String picture, String description) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.picture = picture;
        this.description = description;
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
}
