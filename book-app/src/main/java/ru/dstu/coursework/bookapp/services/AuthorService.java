package ru.dstu.coursework.bookapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dstu.coursework.bookapp.entities.Author;
import ru.dstu.coursework.bookapp.repositories.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author author) {
        if (authorRepository.existsById(id)) {
            author.setId(id);
            return authorRepository.save(author);
        } else {
            return null;
        }
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
