package com.example.bookstore.repository;

import com.example.bookstore.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepositoryCRUD extends JpaRepository<Books, Long> {
    List<Books> findBooksByAuthor(String author);
}