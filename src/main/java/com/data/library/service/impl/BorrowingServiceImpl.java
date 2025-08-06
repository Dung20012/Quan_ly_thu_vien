package com.data.library.service.impl;

import com.data.library.model.entity.Book;
import com.data.library.model.entity.Borrowing;
import com.data.library.repository.IBookRepository;
import com.data.library.repository.IBorrowingRepository;
import com.data.library.service.IBorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class BorrowingServiceImpl implements IBorrowingService {

    @Autowired
    private IBorrowingRepository borrowingRepository;

    @Autowired
    private IBookRepository bookRepository;

    // Tạo yêu cầu mượn sách (user yêu cầu)
    @Override
    public void createBorrowing(Borrowing borrowing) {
        borrowingRepository.create(borrowing);
    }

    // Lấy danh sách các yêu cầu mượn chưa duyệt (admin)
    @Override
    public List<Borrowing> getPendingRequests() {
        return borrowingRepository.findPending();
    }

    // Admin duyệt yêu cầu mượn sách
    @Override
    public void approveRequest(int id) {
        Borrowing borrowing = borrowingRepository.getById(id);
        // ktra yêu cầu tồn tại và chưa đc duyệt
        if (borrowing != null && !borrowing.getApproved()) {
            // Lấy sách liên quan
            Book book = borrowing.getBook();

            // Kiểm tra số lượng còn lại
            if (book.getQuantity() > 0) {
                // Trừ 1 sách
                book.setQuantity(book.getQuantity() - 1);
                bookRepository.updateBook(book); // Cập nhật sách

                // Đánh dấu là đã duyệt
                borrowing.setApproved(true);
                borrowingRepository.update(borrowing); // Cập nhật mượn
            }
        }
    }

    // Admin từ chối yêu cầu mượn sách
    @Override
    public void rejectRequest(int id) {
        Borrowing borrowing = borrowingRepository.getById(id);
        // yêu cầu tồn tại và chưa đc duyệt thì xóa
        if (borrowing != null && !borrowing.getApproved()) {
            borrowingRepository.delete(borrowing);
        }
    }

    // Người dùng trả sách
    @Override
    public void returnBook(int id) {
        Borrowing borrowing = borrowingRepository.getById(id);
        if (borrowing != null && borrowing.getApproved() && !borrowing.getReturned()) {Book book = borrowing.getBook();
            borrowing.setReturned(true); // đã trả
            borrowing.setReturnDate(LocalDate.now()); // ngày trả

            // Cộng lại số lượng sách
            Book book1 = borrowing.getBook();
            book1.setQuantity(book1.getQuantity() + 1);
            bookRepository.updateBook(book1);

            borrowingRepository.update(borrowing);
        }
    }

    // Lấy danh sách mượn sách của 1 user theo ID
    @Override
    public List<Borrowing> getBorrowingByUser(int id) {
        return borrowingRepository.findByUserId(id);
    }

    // Lấy tất cả bản ghi mượn sách (admin xem lịch sử)
    @Override
    public List<Borrowing> getAll() {
        return borrowingRepository.findAll();
    }
}
