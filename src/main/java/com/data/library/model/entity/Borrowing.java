package com.data.library.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "borrowings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "borrow_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "borrow_date")
    private LocalDate borrowDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "returned")
    private Boolean returned = false;

    private Boolean approved = false;
}
