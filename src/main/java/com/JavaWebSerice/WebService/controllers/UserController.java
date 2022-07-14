package com.JavaWebSerice.WebService.controllers;

import com.JavaWebSerice.WebService.dao.UserDao;
import com.JavaWebSerice.WebService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/user/{id}")
    public User getUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setName("Faucndo");
        user.setSurname("Bardi");
        user.setEmail("facundo@mail.com");
        user.setPassword("12341234");
        user.setPhone("341555555");
        return user;
    }
    //returns full list of users
    @RequestMapping(value = "api/users")
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @RequestMapping(value = "userMod")
    public User modUser() {
        User user = new User();
        user.setName("Faucndo");
        user.setSurname("Bardi");
        user.setEmail("facundo@mail.com");
        user.setPassword("12341234");
        user.setPhone("341555555");
        return user;
    }
    @RequestMapping(value = "api/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id) {
        userDao.delete(id);
    }

    @RequestMapping(value = "userSearch")
    public User searchUser() {
        User user = new User();
        user.setName("Faucndo");
        user.setSurname("Bardi");
        user.setEmail("facundo@mail.com");
        user.setPassword("12341234");
        user.setPhone("341555555");
        return user;
    }
}
