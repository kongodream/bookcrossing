package com.bookcrossing.serviceLayer.service.interfaces;


import com.bookcrossing.dataLayer.entity.dto.GenreDTO;

import java.util.List;

public interface GenreService {
    List<GenreDTO> getAllGenres();
}
