package ru.dstu.coursework.bookapp.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer discount;
    private Date start_date;
    private Date end_date;
}
