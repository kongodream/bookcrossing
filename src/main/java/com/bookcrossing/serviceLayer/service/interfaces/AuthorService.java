package com.bookcrossing.serviceLayer.service.interfaces;

import com.bookcrossing.dataLayer.entity.Author;
import com.bookcrossing.dataLayer.entity.dto.AuthorDTO;
import com.bookcrossing.dataLayer.entity.dto.GenreDTO;

import java.util.List;
import java.util.Set;

public interface AuthorService {
    void createAuthors(Set<Author> authors);

    void save(Author author);

    List<AuthorDTO> getAllAuthors();
}
