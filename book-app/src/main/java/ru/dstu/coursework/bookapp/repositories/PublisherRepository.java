package ru.dstu.coursework.bookapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dstu.coursework.bookapp.entities.Publisher;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
