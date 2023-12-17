package ru.dstu.coursework.bookapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dstu.coursework.bookapp.entities.Bestseller;

@Repository
public interface BestsellerRepository extends CrudRepository<Bestseller, Long> {
}
