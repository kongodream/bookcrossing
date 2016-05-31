package com.bookcrossing.dataLayer.entity.dto;


import com.bookcrossing.dataLayer.entity.Author;

public class AuthorDTO {
    private String firstName;
    private String secondName;
    private String surname;

    public AuthorDTO(Author author) {
        this.firstName = author.getFirstName();
        this.secondName = author.getSecondName();
        this.surname = author.getSurname();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
