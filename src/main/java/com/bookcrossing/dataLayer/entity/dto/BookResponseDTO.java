package com.bookcrossing.dataLayer.entity.dto;

import com.bookcrossing.dataLayer.entity.Author;
import com.bookcrossing.dataLayer.entity.Book;
import com.bookcrossing.dataLayer.entity.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BookResponseDTO {
    private int id;
    private String title;
    private List<AuthorDTO> authors;
    private Genre genre;
    private UserDTO creator;
    private String picture;
    private String description;

    public BookResponseDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.authors = createAuthorDTOs(book.getAuthors());
        this.genre = book.getGenre();
        this.creator = new UserDTO(book.getCreator());
        this.picture = book.getPicture();
        this.description = book.getDescription();
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

    public List<AuthorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDTO> authors) {
        this.authors = authors;
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
}
