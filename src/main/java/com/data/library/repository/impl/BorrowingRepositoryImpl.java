package com.data.library.repository.impl;

import com.data.library.model.entity.Borrowing;
import com.data.library.repository.IBorrowingRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BorrowingRepositoryImpl implements IBorrowingRepository {

    @Autowired
    private SessionFactory sessionFactory;

    // Thêm bản ghi mượn mới
    @Override
    public void create(Borrowing borrowing) {
        sessionFactory.getCurrentSession().save(borrowing);
    }

    // Cập nhật thông tin mượn
    @Override
    public void update(Borrowing borrowing) {
        sessionFactory.getCurrentSession().update(borrowing);
    }

    // Xóa bản ghi mượn
    @Override
    public void delete(Borrowing borrowing) {
        sessionFactory.getCurrentSession().delete(borrowing);
    }

    // Lấy bản ghi mượn theo ID
    @Override
    public Borrowing getById(int id) {
        return sessionFactory.getCurrentSession().get(Borrowing.class, id);
    }

    // Lấy danh sách các yêu cầu mượn chưa duyệt
    @Override
    public List<Borrowing> findPending() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Borrowing where approved = false", Borrowing.class)
                .list();
    }

    // Lấy danh sách mượn sách theo ID
    @Override
    public List<Borrowing> findByUserId(int id) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Borrowing where user.id =:id", Borrowing.class)
                .setParameter("id", id)
                .list();
    }

    // Lấy tất cả bản ghi mượn sách
    @Override
    public List<Borrowing> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Borrowing", Borrowing.class)
                .list();
    }
}
