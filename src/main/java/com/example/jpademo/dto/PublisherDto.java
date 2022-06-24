package com.example.jpademo.dto;

import com.example.jpademo.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDto {
    private Long publisherId;
    @NotBlank(message = "publisherName 필수입력")
    private String publisherName;

    @Builder.Default
    private List<BookDto> bookDtos = new ArrayList<>();

    public Publisher toEntity() {
        return Publisher.builder()
                .publisherName(publisherName)
                .build();
    }

    public static PublisherDto of(Publisher publisher) {
        return PublisherDto.builder()
                .publisherId(publisher.getPublisherId())
                .publisherName(publisher.getPublisherName())
                .bookDtos(publisher.getBookDtos())
                .build();
    }
}
