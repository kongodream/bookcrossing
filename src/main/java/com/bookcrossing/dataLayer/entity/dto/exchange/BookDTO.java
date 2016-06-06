package com.bookcrossing.dataLayer.entity.dto.exchange;

import com.bookcrossing.dataLayer.entity.Author;
import com.bookcrossing.dataLayer.entity.Book;
import com.bookcrossing.dataLayer.entity.Genre;
import com.bookcrossing.dataLayer.entity.dto.AuthorDTO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class BookDTO {
    private int id;
    private String title;
    private Genre genre;
    private String picture;
    private List<AuthorDTO> authors;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.genre = book.getGenre();
        this.picture = book.getPicture();
        this.authors = createAuthorDTOs(book.getAuthors());
    }

    private List<AuthorDTO> createAuthorDTOs(Set<Author> authors) {
        return authors
                .stream()
                .map(AuthorDTO::new)
                .collect(Collectors.toList());
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

    public List<AuthorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDTO> authors) {
        this.authors = authors;
    }
}

