package com.data.library.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "book_id")
    private int id;

    private String title;
    private String author;
    private String category;
    private String description;
    private int publication_year;
    private int quantity;

    public Book(int id) {
        this.id = id;
    }
}
