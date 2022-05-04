package com.example.bookstore.repository;

import com.example.bookstore.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AuthorsRepository extends JpaRepository<Authors,Long> {
}
