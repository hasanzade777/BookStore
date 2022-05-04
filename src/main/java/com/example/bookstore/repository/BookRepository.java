package com.example.bookstore.repository;

import com.example.bookstore.model.Books;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<BookRepository, Long> {

    List<Books> findByAuthor(String author);

    List<Books> findBybookName(String bookName, Pageable pageable);
}
