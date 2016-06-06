package com.bookcrossing.dataLayer.entity.dto;


import com.bookcrossing.dataLayer.entity.Author;

public class AuthorDTO {
    private int id;
    private String firstName;
    private String secondName;
    private String surname;

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.firstName = author.getFirstName();
        this.secondName = author.getSecondName();
        this.surname = author.getSurname();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
