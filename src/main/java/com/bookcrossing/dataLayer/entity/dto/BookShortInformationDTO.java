package com.bookcrossing.dataLayer.entity.dto;

import com.bookcrossing.dataLayer.entity.Book;

public class BookShortInformationDTO {
    private int id;
    private String title;
    private GenreDTO genre;
    private String picture;

    public BookShortInformationDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.genre = new GenreDTO(book.getGenre());
        this.picture = book.getPicture();
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

    public GenreDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
