package com.data.library.repository;

import com.data.library.model.entity.Borrowing;

import java.util.List;

public interface IBorrowingRepository {
    void create(Borrowing borrowing);
    void update(Borrowing borrowing);
    void delete(Borrowing borrowing);
    Borrowing getById(int id);

    List<Borrowing> findPending(); // chưa duyệt
    List<Borrowing> findByUserId(int id);
    List<Borrowing> findAll();
}
