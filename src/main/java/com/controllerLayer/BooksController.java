package com.controllerLayer;

import com.dataLayer.entity.dto.BookDTO;
import com.dataLayer.entity.dto.BooksResponseDTO;
import com.dataLayer.entity.dto.RequestBook;
import com.serviceLayer.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BooksController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public
    @ResponseBody
    List<BooksResponseDTO> getBooks() {
        return bookService.getAllBook();
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public
    @ResponseBody
    void saveBook(@RequestBody RequestBook book, Authentication authentication) { bookService.saveBook(book ,authentication); }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    BookDTO getBook(@PathVariable("id") int bookId) {
        return bookService.getBookDTOById(bookId);
    }


}

