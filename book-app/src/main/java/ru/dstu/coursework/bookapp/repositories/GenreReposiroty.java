package ru.dstu.coursework.bookapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dstu.coursework.bookapp.entities.Genre;

@Repository
public interface GenreReposiroty extends CrudRepository<Genre, Integer> {
}
