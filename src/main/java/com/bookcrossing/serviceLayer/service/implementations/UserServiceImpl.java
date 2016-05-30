package com.bookcrossing.serviceLayer.service.implementations;

import com.bookcrossing.dataLayer.dao.interfaces.UserDAO;
import com.bookcrossing.dataLayer.entity.User;
import com.bookcrossing.dataLayer.entity.external.OauthProfile;
import com.bookcrossing.serviceLayer.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

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
