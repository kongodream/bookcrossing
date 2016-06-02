package com.bookcrossing.dataLayer.entity.dto.exchange;

import com.bookcrossing.dataLayer.entity.Book;
import com.bookcrossing.dataLayer.entity.Exchange;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ExchangeDTO {
    private BookDTO desiredBook;
    private List<BookDTO> offeredBooks;
    private LocalDateTime createdAt;

    public ExchangeDTO(Exchange exchange) {
        this.desiredBook = new BookDTO(exchange.getDesiredBook());
        this.offeredBooks = createBookDTOs(exchange.getOfferedBooks());
        this.createdAt = exchange.getCreatedAt();
    }

    private List<BookDTO> createBookDTOs(List<Book> books) {
        return books
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    public BookDTO getDesiredBook() {
        return desiredBook;
    }

    public void setDesiredBook(BookDTO desiredBook) {
        this.desiredBook = desiredBook;
    }

    public List<BookDTO> getOfferedBooks() {
        return offeredBooks;
    }

    public void setOfferedBooks(List<BookDTO> offeredBooks) {
        this.offeredBooks = offeredBooks;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
