package com.example.bookstore.controller;

import com.example.bookstore.model.Books;
import com.example.bookstore.service.Impl.UserServicesImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private UserServicesImpl userServices;

    @GetMapping("book/{author}")
    public List<Books> getBooksByAuthor(@PathVariable String author) {
        return userServices.getTheBooksByAuthor(author);
    }

    @GetMapping
    public List<Books> getAllBooks() {
        return userServices.getAllBooks();
    }

    @GetMapping("/{bookName}")
    public List<Books> getBooksByName(@PathVariable String bookName) {
        return userServices.getTheBooksByName(bookName);
    }
}
