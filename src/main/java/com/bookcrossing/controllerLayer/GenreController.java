package com.bookcrossing.controllerLayer;

import com.bookcrossing.dataLayer.entity.dto.BookShortInformationDTO;
import com.bookcrossing.dataLayer.entity.dto.GenreDTO;
import com.bookcrossing.serviceLayer.service.interfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GenreController {
    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "/api/genres", method = RequestMethod.GET)
    public
    @ResponseBody
    List<GenreDTO> getGenres() {
        return genreService.getAllGenres();
    }

    @RequestMapping(value = "/api/genres/{title}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<BookShortInformationDTO> getBooksByGenre(@PathVariable("title") String title) {
        return genreService.getBooksByGenre(title);
    }
}
