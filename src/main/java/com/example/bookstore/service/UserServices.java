package com.example.bookstore.service;

import com.example.bookstore.model.Books;
import java.util.List;

public interface UserServices {
    List<Books> getTheBooksByAuthor(String author);

    List<Books> getAllBooks();

    List<Books> getTheBooksByName(String bookName);
}
