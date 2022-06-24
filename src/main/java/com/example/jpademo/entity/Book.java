package com.example.jpademo.entity;

import com.example.jpademo.code.State;
import com.example.jpademo.entity.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "book")
@ToString
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "isbn", length = 50)
    private String isbn;

    @Column(name = "author", length = 50)
    private String author;

    @Column(name = "price")
    private double price;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

}
