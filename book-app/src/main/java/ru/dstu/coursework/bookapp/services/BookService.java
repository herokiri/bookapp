package ru.dstu.coursework.bookapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dstu.coursework.bookapp.entities.Book;
import ru.dstu.coursework.bookapp.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return bookRepository.save(book);
        } else {
            return null;
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
