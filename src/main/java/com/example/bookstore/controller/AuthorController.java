package com.example.bookstore.controller;

import com.example.bookstore.model.Books;
import com.example.bookstore.service.Impl.AuthorServicesImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private AuthorServicesImpl authorServices;

    @PostMapping()
    public void addBook(@RequestBody Books book) {
        authorServices.addBook(book);
    }

    @GetMapping
    public List<Books> getAllBooks() {
        return authorServices.getAllBooks();
    }

    @PostMapping("/{id}")
    public void addBookToList(Books book, @PathVariable Long id) {
        authorServices.addBookToList(book, id);
    }

    @GetMapping("/{bookName}")
    public List<Books> getBooksByName(@PathVariable String bookName) {
        return authorServices.getTheBooksByName(bookName);
    }
}
