package com.bookcrossing.serviceLayer.service.interfaces;

import com.bookcrossing.dataLayer.entity.Book;
import com.bookcrossing.dataLayer.entity.dto.BookDTO;
import com.bookcrossing.dataLayer.entity.dto.BooksResponseDTO;
import com.bookcrossing.dataLayer.entity.dto.RequestBook;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface BookService {

    void saveBook(RequestBook book, Authentication authentication);

    List<BooksResponseDTO> getAllBook();

    BookDTO getBookDTOById(int id);

    Book getBookById(int id);

    void setOwner(int bookId, Authentication authentication);

    void remoteOwner(int bookId);
}
