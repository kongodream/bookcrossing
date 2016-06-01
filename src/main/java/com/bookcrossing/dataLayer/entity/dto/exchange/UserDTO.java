package com.bookcrossing.dataLayer.entity.dto.exchange;

import com.bookcrossing.dataLayer.entity.Book;
import com.bookcrossing.dataLayer.entity.User;
import com.bookcrossing.dataLayer.entity.dto.exchange.BookDTO;
import org.hibernate.mapping.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class UserDTO {
    private int id;
    private String email;
    private String name;
    private String familyName;
    private String picture;
    private List<BookDTO> books = new ArrayList<>();

    public UserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.familyName = user.getFamilyName();
        this.picture = user.getPicture();
        this.books = createBookDTOs(user.getBooks());
    }

    private List<BookDTO> createBookDTOs(List<Book> books) {
        return books
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
