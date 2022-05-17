package com.example.bookstore.repository;

import com.example.bookstore.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {
}
