package com.data.library.repository;

import com.data.library.model.entity.Book;
import java.util.List;

public interface IBookRepository {
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);

    Book getBookById(int id);
    List<Book> getAllBooks();

    List<Book> searchBookByTitle(String keyword);
    List<Book> findBookByPage(int offset, int limit);
    int countBooks();
}
