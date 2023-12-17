package ru.dstu.coursework.bookapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dstu.coursework.bookapp.entities.Promotion;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Long> {
}
