package ru.dstu.coursework.bookapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dstu.coursework.bookapp.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
