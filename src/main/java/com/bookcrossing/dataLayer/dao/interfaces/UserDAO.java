package com.bookcrossing.dataLayer.dao.interfaces;

import com.bookcrossing.dataLayer.entity.User;

import java.util.List;

public interface UserDAO {
    public void save(User person);

    public User getUser(long id);

    public User getUserByEmail(String email);

    public User findUsersByEmail(String email);

    public List<User> getListOfAllUsers();
}
