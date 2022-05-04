package com.example.bookstore.service;

import com.example.bookstore.model.Authors;
import com.example.bookstore.model.BookDetails;
import com.example.bookstore.model.Books;
import java.util.List;

public interface AuthorServices {
    void addBookToList(Books book,Long id);
    void updateBookDetailByAuthor(String author, BookDetails bookDetail,String bookName);
    void addBook(Books book);
    List<Books> getAllBooks();
    List<Books> getTheBooksByName(String bookName);
}
