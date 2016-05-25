package com.dataLayer.entity.dto;

public class RequestBook {
    private String name;
    private String author;
    private String genre;
    private String picture;
    private String description;

    public RequestBook() {
    }

    public RequestBook(String name, String author, String genre, String picture, String description) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.picture = picture;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
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
