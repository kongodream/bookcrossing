package com.bookcrossing.serviceLayer.service.interfaces;

import com.bookcrossing.dataLayer.entity.User;
import com.bookcrossing.dataLayer.entity.external.OauthProfile;

public interface UserService {
    void saveUser(User person);

    void saveUser(String email);

    User getUser(long id);

    User getUserByEmail(String email);

    User getUserFromOauthUser(OauthProfile oauthProfile);
}
