package com.serviceLayer.service.implementations;

import com.dataLayer.dao.interfaces.BookDAO;
import com.dataLayer.entity.Book;
import com.dataLayer.entity.dto.BookDTO;
import com.dataLayer.entity.dto.BooksResponseDTO;
import com.dataLayer.entity.dto.RequestBook;
import com.dataLayer.entity.User;
import com.serviceLayer.service.interfaces.BookService;
import com.serviceLayer.service.interfaces.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDAO bookDAO;
    @Autowired
    TransferService transferService;

    @Override
    public void saveBook(RequestBook book, Authentication authentication) {
        User creator = ((User) authentication.getPrincipal());
        Book newBook = new Book(book, creator);
        bookDAO.save(newBook);

    }

    @Override
    public List<BooksResponseDTO> getAllBook() {
        List<BooksResponseDTO> booksResponseDTOs = new ArrayList<>();
        for (Book book : bookDAO.getListOfAllBooks()) {
            booksResponseDTOs.add(new BooksResponseDTO(book));
        }
        return booksResponseDTOs;
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
