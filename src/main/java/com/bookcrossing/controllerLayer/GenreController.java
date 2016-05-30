package com.bookcrossing.controllerLayer;

import com.bookcrossing.dataLayer.entity.Genre;
import com.bookcrossing.serviceLayer.service.interfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
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
