package com.example.jpademo.dto;

import com.example.jpademo.code.State;
import com.example.jpademo.entity.Book;
import com.example.jpademo.entity.Publisher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long bookId;
    private String title;
    private String isbn;
    private String author;
    private Double price;
    private State state;

    @JsonIgnore
    private Publisher publisher;

    private Long publisherId;


    public Book toEntity() {
        return Book.builder()
                .bookId(bookId)
                .title(title)
                .isbn(isbn)
                .author(author)
                .state(state)
                .price(price)
                .publisher(publisher)
                .build();
    }

    public static BookDto of(Book book) {
        return BookDto.builder()
                .bookId(book.getBookId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .author(book.getAuthor())
                .state(book.getState())
                .price(book.getPrice())
                .publisherId(book.getPublisher().getPublisherId())
                .build();
    }
}
