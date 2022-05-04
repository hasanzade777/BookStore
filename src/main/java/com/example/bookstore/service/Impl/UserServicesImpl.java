package com.example.bookstore.service.Impl;

import com.example.bookstore.model.Books;
import com.example.bookstore.model.Users;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.UsersRepository;
import com.example.bookstore.service.UserServices;
import java.awt.print.Pageable;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {
    private final UsersRepository usersRepository;
    private final BookRepository bookRepository;
    private Users user;

    @Override
    public void addUser(Users user) {
        usersRepository.save(user);
    }

    @Override
    public String userLogOn(String username, String password) {
        user = usersRepository.findBy(username, password);
        if (user != null) {
            return "Success";

        } else {
            return "Error:The user not found";
        }
    }

    @Override
    public List<Books> getTheBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }


    @Override
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Books> getTheBooksByName(String bookName) {
        Pageable pageable= (Pageable) PageRequest.of(0,2);
        return bookRepository.findBybookName(bookName,pageable);
    }
}
