package com.example.bookstore.service;

import com.example.bookstore.model.Authors;
import com.example.bookstore.model.BookDetails;
import com.example.bookstore.model.Books;
import java.util.List;

public interface AuthorServices {
    void addAuthor(Authors author);
    String authorLogOn(String username,String password);
    void addBookToList(Books book,Long id);
    void updateBookDetailByAuthorID(Long authorID, BookDetails bookDetail);
    void addBook(Books book);
    List<Books> getAllBooks();
    List<Books> getTheBooksByName(String bookName);
}
