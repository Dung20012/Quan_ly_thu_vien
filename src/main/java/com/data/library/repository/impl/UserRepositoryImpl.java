package com.data.library.repository.impl;

import com.data.library.model.entity.User;
import com.data.library.repository.IUserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    // Lưu user mới vào CSDL
    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    // Tìm user theo username (đăng nhập, ktra trùng tên)
    @Override
    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User where username =:username", User.class)
                .setParameter("username", username).uniqueResult();
    }

    // Trả về tất cả danh sách người dùng
    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).list();
    }

    // Tìm user theo email (ktra trùng email khi đăng ký)
    @Override
    public User findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User where email =:email", User.class)
                .setParameter("email", email).uniqueResult();
    }
}
