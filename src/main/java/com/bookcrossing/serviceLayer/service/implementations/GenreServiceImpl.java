package com.bookcrossing.serviceLayer.service.implementations;

import com.bookcrossing.dataLayer.dao.interfaces.GenreDAO;
import com.bookcrossing.dataLayer.entity.Genre;
import com.bookcrossing.serviceLayer.service.interfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreDAO genreDAO;

    @Override
    public List<Genre> getAllGenres() {
        return genreDAO.getAllGenres();
    }
}
