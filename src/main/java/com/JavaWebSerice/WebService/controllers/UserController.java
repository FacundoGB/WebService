package com.JavaWebSerice.WebService.controllers;

import com.JavaWebSerice.WebService.dao.UserDao;
import com.JavaWebSerice.WebService.models.User;
import com.JavaWebSerice.WebService.utlis.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/users/{id}")
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

    //token validation method
    private boolean validateToken(String token) {
               /*
        We must validate the token to allow requests (ie. see al users or delete)
        We can select for key of value of jwtUtil. When we built the token we parsed 2 values (id &value)
        in key it return id of user. We extract the user id.
         */

        String userId = jwtUtil.getKey(token);
        return userId != null;

    }

    //returns full list of users
    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> listUsers(@RequestHeader(value="Authorization") String token) {
        if (!validateToken(token)) {
            return null;
        }
        return userDao.listUsers();
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user) {

        Argon2 encrypt = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id, 16, 32);
        char [] password = user.getPassword().toCharArray();
        String hash = encrypt.hash(1, 1024, 1, password);
        /*
            https://en.wikipedia.org/wiki/Argon2
            https://mkyong.com/java/java-password-hashing-with-argon2/
            https://stackoverflow.com/questions/66594009/java-argon2-hashing Try this one later better security
         */
        user.setPassword(hash);
        userDao.register(user);
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@RequestHeader(value="Authorization") String token, @PathVariable long id) {
        //we verify in delete
        if (!validateToken(token)) {
            return;
        }
        userDao.delete(id);
    }

}
