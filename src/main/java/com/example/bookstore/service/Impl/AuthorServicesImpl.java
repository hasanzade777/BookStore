package com.example.bookstore.service.Impl;

import com.example.bookstore.model.Authors;
import com.example.bookstore.model.BookDetails;
import com.example.bookstore.model.Books;
import com.example.bookstore.repository.AuthorsRepository;
import com.example.bookstore.repository.BooksRepository;
import com.example.bookstore.repository.BooksRepositoryCRUD;
import com.example.bookstore.service.AuthorServices;
import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServicesImpl implements AuthorServices {
    private AuthorsRepository authorsRepository;
    private BooksRepository bookRepository;
    private BooksRepositoryCRUD booksRepositoryCRUD;

    @Override
    public void addBookToList(Books book, Long id) {
        Authors author = authorsRepository.findById(id).stream().findFirst().orElseThrow(RuntimeException::new);
        booksRepositoryCRUD.save(book).setAuthor(author);
    }

    @Override
    public void updateBookDetailByAuthor(String Author, BookDetails bookDetail, String bookName) {
        List<Books> booksList = booksRepositoryCRUD.findBooksByAuthor(Author)
                .stream()
                .filter(books -> books.getBookName().equals(bookName)).collect(Collectors.toList());
        if (!booksList.isEmpty()) {
            booksRepositoryCRUD.save(booksList.get(0)).setBookDetails(bookDetail);
        }

    }

    @Override
    public void addBook(Books book) {
        booksRepositoryCRUD.save(book);
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
