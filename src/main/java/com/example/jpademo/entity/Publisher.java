package com.example.jpademo.entity;

import com.example.jpademo.dto.BookDto;
import com.example.jpademo.dto.PublisherDto;
import com.example.jpademo.entity.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "publisher")
public class Publisher extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long publisherId;

    @Column(name = "publisher_name", length = 100)
    private String publisherName;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Book> books = new ArrayList<>();


    public void addBooks(List<BookDto> bookDtos) {
        bookDtos.forEach(bookDto -> {
            bookDto.setPublisher(this);
            books.add(bookDto.toEntity());
        });
    }

    public List<BookDto> getBookDtos() {
        return books.stream().map(book -> BookDto.builder()
                .bookId(book.getBookId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .author(book.getAuthor())
                .price(book.getPrice())
                .state(book.getState())
                .publisherId(book.getPublisher().getPublisherId())
                 .build())
                .collect(Collectors.toList());
    }

    public void update(PublisherDto publisherDto) {
        publisherName = publisherDto.getPublisherName();
    }
}
