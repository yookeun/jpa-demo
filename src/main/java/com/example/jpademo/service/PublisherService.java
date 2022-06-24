package com.example.jpademo.service;

import com.example.jpademo.dto.PublisherDto;
import com.example.jpademo.entity.Publisher;
import com.example.jpademo.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;

    @Transactional
    public PublisherDto save(PublisherDto publisherDto) {
        Publisher publisher = publisherDto.toEntity();
        publisher.addBooks(publisherDto.getBookDtos());
        publisherRepository.save(publisher);
        return PublisherDto.of(publisher);
    }

    @Transactional
    public PublisherDto update(PublisherDto publisherDto) {
        Publisher publisher = publisherRepository
                .findById(publisherDto.getPublisherId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 ID"));
        publisher.getBooks().clear();
        publisher.addBooks(publisherDto.getBookDtos());
        publisher.update(publisherDto);
        publisherRepository.flush();
        return PublisherDto.of(publisher);
    }

    public PublisherDto getOne(Long publisherId) {
        Publisher publisher = publisherRepository
                .findById(publisherId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 ID"));
        return PublisherDto.of(publisher);
    }

    public List<PublisherDto> getList() {
        List<Publisher> publishers = publisherRepository.findAll();
        return publishers.stream()
                .map(publisher -> PublisherDto.of(publisher))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long publisherId) {
        Publisher publisher = publisherRepository
                .findById(publisherId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 ID"));
        publisherRepository.delete(publisher);
    }

}
