package com.example.bookstore.controller;

import com.example.bookstore.model.Books;
import com.example.bookstore.service.Impl.AuthorServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
