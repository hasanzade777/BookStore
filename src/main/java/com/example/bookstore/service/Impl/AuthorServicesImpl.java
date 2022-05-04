package com.example.bookstore.service.Impl;

import com.example.bookstore.model.Authors;
import com.example.bookstore.model.BookDetails;
import com.example.bookstore.model.Books;
import com.example.bookstore.repository.AuthorsRepository;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.AuthorServices;
import java.awt.print.Pageable;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServicesImpl implements AuthorServices {
    private final AuthorsRepository authorsRepository;
    private final BookRepository bookRepository;
    private Authors author;

    @Override
    public void addAuthor(Authors author) {
        authorsRepository.save(author);
    }

    @Override
    public String authorLogOn(String username, String password) {
        author = authorsRepository.findBy(username, password);
        if (author != null) {
            return "Success";
        } else {
            return "Error:The user not found";
        }
    }

    @Override
    public void addBookToList(Books book, Long id) {
        author = authorsRepository.findById(id).orElseThrow(RuntimeException::new);
        if (author != null) {
            book.setAuthor(author);
            bookRepository.save(book);
        }
    }

    @Override
    public void updateBookDetailByAuthorID(Long authorID, BookDetails bookDetail) {
        bookRepository.findByAuthorId(authorID).setBookDetails(bookDetail);
    }
    @Override
    public void addBook(Books book) {
        bookRepository.save(book);
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
