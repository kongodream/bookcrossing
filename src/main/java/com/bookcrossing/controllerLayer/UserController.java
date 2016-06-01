package com.bookcrossing.controllerLayer;

import com.bookcrossing.dataLayer.entity.User;
import com.bookcrossing.dataLayer.entity.dto.exchange.UserDTO;
import com.bookcrossing.serviceLayer.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/getCurrentUser")
    public
    @ResponseBody
    UserDTO getCurrentUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        User user1 = userService.getUserByEmail(user.getEmail());
        return new UserDTO(user1);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    UserDTO getUserById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        return new UserDTO(user);
    }
}
