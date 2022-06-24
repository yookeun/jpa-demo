package com.example.jpademo.repository;

import com.example.jpademo.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long>, PublisherRepositoryCustom {
}
