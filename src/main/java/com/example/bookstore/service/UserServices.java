package com.example.bookstore.service;

import com.example.bookstore.model.Books;
import com.example.bookstore.model.Users;
import java.util.List;

public interface UserServices {
    void addUser(Users user);
    String userLogOn(String username,String password);
    List<Books> getTheBooksByAuthor(String author);
    List<Books> getAllBooks();
    List<Books> getTheBooksByName(String bookName);
}
