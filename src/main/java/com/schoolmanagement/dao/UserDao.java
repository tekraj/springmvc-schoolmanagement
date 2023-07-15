package com.schoolmanagement.dao;

import com.schoolmanagement.bean.User;

public interface UserDao {
    void save(User user);

    User getById(int id);

    User getByEmail(String email);

    void update(User user);

    void delete(int id);

    boolean validateUser(String email, String password);
}
