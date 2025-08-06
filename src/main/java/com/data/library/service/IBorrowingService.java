package com.data.library.service;

import com.data.library.model.entity.Borrowing;

import java.util.List;

public interface IBorrowingService {
    void createBorrowing(Borrowing borrowing);
    List<Borrowing> getPendingRequests();

    void approveRequest(int id);
    void rejectRequest(int id);
    void returnBook(int id);

    List<Borrowing> getBorrowingByUser(int id);
    List<Borrowing> getAll();
}
