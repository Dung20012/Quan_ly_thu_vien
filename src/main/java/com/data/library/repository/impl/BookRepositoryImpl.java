package com.data.library.repository.impl;

import com.data.library.model.entity.Book;
import com.data.library.repository.IBookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements IBookRepository {

    @Autowired
    private SessionFactory sessionFactory;

    // Lấy phiên làm việc hiện tại của Hibernate
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    // Thêm mới sách
    @Override
    public void addBook(Book book) {
        getSession().save(book);
    }

    // Cập nhật sách
    @Override
    public void updateBook(Book book) {
        getSession().update(book);
    }

    // Xóa sách theo ID
    @Override
    public void deleteBook(int id) {
        Book book = getBookById(id);
        if (book != null) {
            getSession().delete(book);
        }
    }

    // Tìm sách theo ID
    @Override
    public Book getBookById(int id) {
        return getSession().get(Book.class, id);
    }

    // Lấy danh sách sách
    @Override
    public List<Book> getAllBooks() {
        return getSession().createQuery("from Book", Book.class).list();
    }

    // Tìm sách theo tiêu đề (likt %keyword%)
    @Override
    public List<Book> searchBookByTitle(String keyword) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Book as book where book.title like :keyword";
        return session.createQuery(hql, Book.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }

    // Lấy danh sách sách thep phân trang
    @Override
    public List<Book> findBookByPage(int offset, int limit) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Book", Book.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    // Đếm tổng số sách (phân trang)
    @Override
    public int countBooks() {
        String hql = "select count(*) from Book";
        Long count = (Long) sessionFactory.getCurrentSession()
                .createQuery(hql)
                .uniqueResult();
        return count.intValue();
    }
}
