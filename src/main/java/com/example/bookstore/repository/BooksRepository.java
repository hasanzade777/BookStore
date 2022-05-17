package com.example.bookstore.repository;

import com.example.bookstore.model.Books;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
    Books findByAuthorId(Long id);

    List<Books> findBybookName(String bookName, Pageable pageable);

    List<Books> findByAuthorName(String author);
}