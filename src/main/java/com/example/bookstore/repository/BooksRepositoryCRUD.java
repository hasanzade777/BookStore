package com.example.bookstore.repository;

import com.example.bookstore.model.Books;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepositoryCRUD extends JpaRepository<Books, Long> {
    List<Books> findBooksByAuthor(String author);
}