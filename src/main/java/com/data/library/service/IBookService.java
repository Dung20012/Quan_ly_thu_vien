package com.data.library.service;


import com.data.library.model.entity.Book;

import java.util.List;

public interface IBookService {
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);

    Book getById(int id);
    List<Book> getAllBooks();

    List<Book> searchBookByTitle(String keyword);
    List<Book> getBookByPage(int page, int size);
    int getBookCount();
}
