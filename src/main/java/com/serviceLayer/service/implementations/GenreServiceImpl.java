package com.serviceLayer.service.implementations;

import com.dataLayer.dao.interfaces.GenreDao;
import com.dataLayer.entity.Genre;
import com.serviceLayer.service.interfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreDao genreDao;

    @Override
    public List<Genre> getAllGenres() {
        return genreDao.getAllGenres();
    }
}
