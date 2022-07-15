package com.JavaWebSerice.WebService.controllers;

import com.JavaWebSerice.WebService.dao.UserDao;
import com.JavaWebSerice.WebService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//specific class for authentication separated from user
@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody User user) {
        if(userDao.verifyCredentials(user)) {
            return "ok.";
        }
        return "FAIL";
    }
}
