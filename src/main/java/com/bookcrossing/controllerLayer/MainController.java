package com.bookcrossing.controllerLayer;

import com.bookcrossing.dataLayer.entity.dto.UserDTO;
import com.bookcrossing.dataLayer.entity.User;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping(value = "/partials/{part}")
    public String getPartialPage(@PathVariable("part") String part) {
        return "partials/" + part;
    }

    @RequestMapping(value = "/")
    public String getMain() {
        return "main";
    }

    @RequestMapping(value = "/getCurrentUser")
    public
    @ResponseBody
    UserDTO getCurrentUserEmail(Authentication authentication) {
        return new UserDTO((User) authentication.getPrincipal());
    }

    @RequestMapping(value = "/app")
    public String events() {
        return "app";
    }
}

