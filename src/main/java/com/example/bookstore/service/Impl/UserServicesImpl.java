package com.example.bookstore.service.Impl;

import com.example.bookstore.model.Books;
import com.example.bookstore.model.Users;
import com.example.bookstore.repository.BooksRepository;
import com.example.bookstore.repository.BooksRepositoryCRUD;
import com.example.bookstore.repository.UsersRepository;
import com.example.bookstore.service.UserServices;
import java.awt.print.Pageable;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {
    private UsersRepository usersRepository;
    private BooksRepository bookRepository;
    private BooksRepositoryCRUD booksRepositoryCRUD;
    private Users user;

    @Override
    public List<Books> getTheBooksByAuthor(String author) {
        return bookRepository.findByAuthorName(author);
    }

    @Override
    public List<Books> getAllBooks() {
        return booksRepositoryCRUD.findAll();
    }

    @Override
    public List<Books> getTheBooksByName(String bookName) {
        Pageable pageable = (Pageable) PageRequest.of(0, 2);
        return bookRepository.findBybookName(bookName, pageable);
    }
}
