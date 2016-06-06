package com.bookcrossing.controllerLayer;

import com.bookcrossing.dataLayer.entity.Author;
import com.bookcrossing.dataLayer.entity.Book;
import com.bookcrossing.dataLayer.entity.Exchange;
import com.bookcrossing.dataLayer.entity.User;
import com.bookcrossing.dataLayer.entity.dto.BookDTO;
import com.bookcrossing.dataLayer.entity.dto.BookResponseDTO;
import com.bookcrossing.dataLayer.entity.dto.RequestBook;
import com.bookcrossing.dataLayer.entity.dto.exchange.ExchangeDTO;
import com.bookcrossing.serviceLayer.service.interfaces.AuthorService;
import com.bookcrossing.serviceLayer.service.interfaces.BookService;
import com.bookcrossing.serviceLayer.service.interfaces.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private ExchangeService exchangeService;

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
    void saveBook(@RequestBody Book book, Authentication authentication) {
        bookService.save(book, authentication);
    }

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.PUT)
    public
    @ResponseBody
    Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book) {
        bookService.update(book);
        return book;
    }

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

    @RequestMapping(value = "/books/{bookId}/exchanges", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createExchange(@PathVariable("bookId") int bookId, @RequestBody List<Book> offersCart,
                               Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        Book desiredBook = bookService.getBookById(bookId);
        Exchange exchange = new Exchange(currentUser, desiredBook.getOwner(), desiredBook, offersCart);
        exchangeService.saveExchange(exchange);
    }
}

