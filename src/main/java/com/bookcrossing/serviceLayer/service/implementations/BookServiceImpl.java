package com.bookcrossing.serviceLayer.service.implementations;

import com.bookcrossing.dataLayer.dao.interfaces.BookDAO;
import com.bookcrossing.dataLayer.entity.Book;
import com.bookcrossing.dataLayer.entity.dto.BookDTO;
import com.bookcrossing.dataLayer.entity.dto.BookResponseDTO;
import com.bookcrossing.dataLayer.entity.dto.RequestBook;
import com.bookcrossing.dataLayer.entity.User;
import com.bookcrossing.serviceLayer.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Override
    public void saveBook(RequestBook book, Authentication authentication) {
        User creator = ((User) authentication.getPrincipal());
        Book newBook = new Book(book, creator);
        bookDAO.save(newBook);

    }

    @Override
    public List<BookResponseDTO> getAllBook() {
        List<BookResponseDTO> bookResponseDTOs = new ArrayList<>();
        for (Book book : bookDAO.getListOfAllBooks()) {
            bookResponseDTOs.add(new BookResponseDTO(book));
        }
        return bookResponseDTOs;
    }

    @Override
    public BookDTO getBookDTOById(int id) {
        return new BookDTO(bookDAO.getBookById(id));
    }

    @Override
    public Book getBookById(int id) {
        return bookDAO.getBookById(id);
    }

    @Override
    public void setOwner(int bookId, Authentication authentication) {
        User owner = ((User) authentication.getPrincipal());
        bookDAO.setOwner(bookId, owner.getId());
    }

    @Override
    public void remoteOwner(int bookId) {
        bookDAO.setOwner(bookId);
    }
}
