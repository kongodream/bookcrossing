package com.bookcrossing.serviceLayer.service.implementations;

import com.bookcrossing.dataLayer.dao.interfaces.GenreDAO;
import com.bookcrossing.dataLayer.entity.Genre;
import com.bookcrossing.dataLayer.entity.dto.GenreDTO;
import com.bookcrossing.serviceLayer.service.interfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreDAO genreDAO;

    @Override
    public List<GenreDTO> getAllGenres() {
        List<Genre> genres = genreDAO.getAllGenres();
        return genres.stream()
                .map(genre -> new GenreDTO(genre))
                .collect(Collectors.toList());
    }
}
