package com.JavaWebSerice.WebService.controllers;

import com.JavaWebSerice.WebService.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "user/{id}")
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
    @RequestMapping(value = "userDel")
    public User deleteUser() {
        User user = new User();
        user.setName("Faucndo");
        user.setSurname("Bardi");
        user.setEmail("facundo@mail.com");
        user.setPassword("12341234");
        user.setPhone("341555555");
        return user;
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
