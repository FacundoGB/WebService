package com.JavaWebSerice.WebService.controllers;

import com.JavaWebSerice.WebService.dao.UserDao;
import com.JavaWebSerice.WebService.models.User;
import com.JavaWebSerice.WebService.utlis.JWTUtil;
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

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody User user) {

        User loggedUser = userDao.obtainUserForCredentials(user);
        if(loggedUser != null) {
            System.out.println("USER IS NOT NULL -- AuthController");
            /*
            we should return the token.
            We've created the token, we need to save it client side and verify it.
            In login.js we verify the answer for the login.
            We can add more things to be returned to reduce requests.
            But in this case we keep it simple.
             */
            String tokenJwt = jwtUtil.create(String.valueOf(loggedUser.getId()), loggedUser.getEmail());
            System.out.println("user id: " + String.valueOf(loggedUser.getId()));
            System.out.println("user email: " + loggedUser.getEmail());
            System.out.println("token: " + tokenJwt);
            return tokenJwt;
        }
        return "FAIL";
    }
}
