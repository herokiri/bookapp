package ru.dstu.coursework.bookapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dstu.coursework.bookapp.entities.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
