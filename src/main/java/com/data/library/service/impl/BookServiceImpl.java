package com.data.library.service.impl;

import com.data.library.model.entity.Book;
import com.data.library.repository.IBookRepository;
import com.data.library.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    // Thêm mới sách
    @Override
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    // Cập nhật thông tin sách
    @Override
    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    // Xóa sách theo ID
    @Override
    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }

    // Lấy sách theo ID
    @Override
    public Book getById(int id) {
        return bookRepository.getBookById(id);
    }

    // Lấy tất cả sách
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    // Tìm kiếm sách theo tiêu đề (gần đúng)
    @Override
    public List<Book> searchBookByTitle(String keyword) {
        return bookRepository.searchBookByTitle(keyword);
    }

    // Lấy danh sách sách theo phân trang
    @Override
    public List<Book> getBookByPage(int page, int size) {
        int offset = (page - 1) * size; // Tính vị trí bắt đầu
        return bookRepository.findBookByPage(offset, size);
    }

    // Đếm tổng số sách (phục vụ cho phân trang)
    @Override
    public int getBookCount() {
        return bookRepository.countBooks();
    }
}
