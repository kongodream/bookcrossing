package com.bookcrossing.controllerLayer;

import com.bookcrossing.dataLayer.entity.dto.AuthorDTO;
import com.bookcrossing.dataLayer.entity.dto.GenreDTO;
import com.bookcrossing.serviceLayer.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/api/authors", method = RequestMethod.GET)
    public
    @ResponseBody
    List<AuthorDTO> getAuthors() {
        return authorService.getAllAuthors();
    }
}
