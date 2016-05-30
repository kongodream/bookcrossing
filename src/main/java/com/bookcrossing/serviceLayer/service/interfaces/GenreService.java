package com.bookcrossing.serviceLayer.service.interfaces;


import com.bookcrossing.dataLayer.entity.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAllGenres();
}
