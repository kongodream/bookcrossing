package com.serviceLayer.service.implementations;

import com.dataLayer.dao.interfaces.UserDAO;
import com.dataLayer.entity.User;
import com.dataLayer.entity.external.OauthProfile;
import com.serviceLayer.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public void saveUser(User user) {
        if (getUserByEmail(user.getEmail()) == null) {
            userDAO.save(user);
        }
    }

    @Override
    public void saveUser(String email) {
        if (getUserByEmail(email) == null) {
            userDAO.save(new User(email));
        }
    }

    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public User getUserFromOauthUser(OauthProfile oauthProfile) {
        User user = new User();
        user.setName(oauthProfile.getName());
        user.setEmail(oauthProfile.getEmail());
        user.setFamilyName(oauthProfile.getFamilyName());
        user.setGender(oauthProfile.getGender());
        user.setPicture(oauthProfile.getPicture());
        return user;
    }
}
