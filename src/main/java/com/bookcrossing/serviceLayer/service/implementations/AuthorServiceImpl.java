package com.bookcrossing.serviceLayer.service.implementations;

import com.bookcrossing.dataLayer.dao.interfaces.AuthorDAO;
import com.bookcrossing.dataLayer.entity.Author;
import com.bookcrossing.dataLayer.entity.dto.AuthorDTO;
import com.bookcrossing.serviceLayer.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public void createAuthors(Set<Author> authors) {

    }

    @Override
    public void save(Author author) {
        authorDAO.save(author);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorDAO.getAllAuthors()
                .stream()
                .map(author -> new AuthorDTO(author))
                .collect(Collectors.toList());
    }
}
