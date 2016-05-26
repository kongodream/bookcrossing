package com.controllerLayer;

import com.dataLayer.entity.Genre;
import com.serviceLayer.service.interfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {
    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "/genres", method = RequestMethod.GET)
    public List<Genre> listGenres() {
        List<Genre> genres = genreService.getAllGenres();
        return genres;
    }
}
