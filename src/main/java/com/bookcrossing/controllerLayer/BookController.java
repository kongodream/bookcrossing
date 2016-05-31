package com.bookcrossing.controllerLayer;

import com.bookcrossing.dataLayer.entity.Author;
import com.bookcrossing.dataLayer.entity.dto.BookDTO;
import com.bookcrossing.dataLayer.entity.dto.BookResponseDTO;
import com.bookcrossing.dataLayer.entity.dto.RequestBook;
import com.bookcrossing.serviceLayer.service.interfaces.AuthorService;
import com.bookcrossing.serviceLayer.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public
    @ResponseBody
    List<BookResponseDTO> getBooks() {
        return bookService.getAllBook();
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public
    @ResponseBody
    void saveBook(@RequestBody RequestBook book, Authentication authentication) { bookService.saveBook(book ,authentication); }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    BookDTO getBook(@PathVariable("id") int bookId) {
        return bookService.getBookDTOById(bookId);
    }

    @RequestMapping(value = "/books/authors", method = RequestMethod.POST)
    public void saveNewSkills(@RequestBody List<Author> authors) {
        authorService.createAuthors(new HashSet<>(authors));
    }
}

